import java.io.*;
import java.util.*;

/**
 * 방법1. 등산할 때의 최소 시간을 구하는 다익스트라와 하산할 때의 최소 시간을 구하는 다익스트라를 따로 구해서 둘이 합치는 방법
 */

public class Main_BAEKJOON_1486_등산_Gold2_1472ms {
	static class Point implements Comparable<Point>{
		int r, c, h;

		public Point(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.h = h;
		}

		@Override
		public int compareTo(Point o) {
			return o.h - this.h; // 내림차순으로 정렬되도록
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int INF;
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int N, M, T, D, lastPoint;
	static int[][] map, climbUpTime, climbDownTime;
	static Queue<Point> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken()); 
		D = Integer.parseInt(st.nextToken());
		
		INF = D + 1; // 걸리는 시간을 초기화 하기 위한 무한대의 값, Integer.MAX_VALUE로 설정하니까 (등산 시간+하산 시간)을 했을 때 값이 음수로 바뀌는 문제가 있어서 D+1로 초기화	
		lastPoint = N*M; // 자주 사용하므로 전체 map 칸의 개수를 저장
		
		// 알파벳으로 지도를 저장하면 비교할 때 헷갈리니까 그냥 아예 수로 바꿔서 저장해버리자
		// 그런데 또 어차피 char 간에는 등호 연산이 가능한데 수로 바꾸지 말까? 하다가 소문자랑 대문자 간의 이동 가능 유무를 판단하기 위해서는 바꿔야겠다고 생각함
		// A : 65, Z : 90, a : 97, z : 122
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				if(line.charAt(j) >= 'a') map[i][j] = line.charAt(j) - 71;
				else map[i][j] = line.charAt(j) - 'A';
				pq.add(new Point(i, j, map[i][j]));
			}
		}
		
		climbUpTime = new int[N][M]; // 호텔에서 각 지점까지 등산하는데 걸리는 시간을 저장하기 위한 2차원 배열
		climbDownTime = new int[N][M]; // 각 지점에서 호텔까지 하산하는데 걸리는 시간을 저장하기 위한 2차원 배열
		
		for(int i = 0; i < N; i++) { // 다익스트라1. 각 지점마다 걸리는 시간을 무한대로 초기화
			Arrays.fill(climbUpTime[i], INF);
		}
		
		climb(0);
		
		int highest = 0;
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			int start = p.r*M + p.c%M;
			climb(start);
			
			if(climbUpTime[p.r][p.c] + climbDownTime[0][0] <= D) {
				System.out.println(map[p.r][p.c]);
				break;
			}
		}
		
	} // end of main

	// climbUp과 climbDown도 얕은 복사를 사용해서 두 메소드를 하나로 합칠 수는 없을까?	
	// 해결해야하는 문제. 등산인지 하산인지에 따라 걸리는 시간을 저장할 2차원 배열을 다르게 지정해주어야 한다.	
	private static void climb(int start) {
		int[][] time = new int[N][M];
		
		if(start != 0) {
			for(int i = 0; i < N; i++) { // 하산은 하산 시작 지점이 매번 달라지므로 climbDown에서 무한대로 초기화
				Arrays.fill(climbDownTime[i], INF);
			}
			time = climbDownTime;
		} else {
			time = climbUpTime;
		}
		
		
		int R = start/M;
		int C = start%M;
		time[R][C] = 0; // 시작지점을 0으로 갱신
		
		boolean[][] isVisited = new boolean[N][M];
		
		// 아래서부터는 다익스트라 알고리즘
		for(int i = 0; i < lastPoint; i++) {
			int min = INF;
			int curr = -1;
			
			for(int j = 0; j < lastPoint; j++) {
				R = j / M;
				C = j % M;
				if(!isVisited[R][C] && time[R][C] < min) {
					min = time[R][C];
					curr = j;
				}
			}
			
			if(curr == -1) break;
			
			R = curr / M;
			C = curr % M;
			isVisited[R][C] = true;
			
			for(int d = 0; d < 4; d++) { // 인접한 좌표 중에서
				int nr = R + dir[d][0];
				int nc = C + dir[d][1];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(!isVisited[nr][nc] && Math.abs(map[nr][nc] - map[R][C]) <= T) { // 아직 방문하지 않았고 두 지점의 높이 차가 T 이내이면 이동 가능
						if(map[nr][nc] > map[R][C]) { // 현 위치보다 높다면 두 위치의 높이의 차이의 제곱만큼 시간이 걸림
							if(time[nr][nc] > time[R][C] + Math.pow(map[nr][nc]-map[R][C], 2)) {
								time[nr][nc] = (int) (time[R][C] + Math.pow(map[nr][nc]-map[R][C], 2));
							}
						} else { // 현 위치보다 낮다면 1초 증가
							if(time[nr][nc] > time[R][C] + 1) {
								time[nr][nc] = time[R][C] + 1;
							}
						}
					}
				}
			}			
		}
	}
	
} // end of class
