import java.io.*;
import java.util.*;

/**
 * A(0) ~ Z(25), a(26) ~ z(51)
 * 현재 위치에서 바로 인접한 정수 좌표 중 높이의 차이가 T보다 크지 않은 곳으로만 이동 가능
 * 	- 낮은 곳이나 같은 곳으로 이동하면 1초 소요
 * 	- 높은 곳으로 이동한다면 두 위치의 높이 차의 제곱 소요
 * D보다 크지 않은 시간 동안 올라갈 수 있는 최대 높이를 구하기
 * 
 * BFS랑 합쳐야하나?
 * 
 */
public class Main_BAEKJOON_1486_등산_Gold2_000ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int INF;
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int N, M, T, D, lastPoint;
	static int[][] map, climbUpTime, climbDownTime;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken()); // 인접한 좌표와의 차이가 T 이내이면 이동 가능
		D = Integer.parseInt(st.nextToken()); // 어두워지는 시간
		
		INF = D + 1;
		lastPoint = N*M;
		map = new int[N][M];
		// 알파벳으로 지도를 저장하면 비교할 때 헷갈리니까 그냥 아예 수로 바꿔서 저장해버리자
		// 그런데 또 어차피 char 간에는 등호 연산이 가능한데 수로 바꾸지 말까? 하다가 소문자랑 대문자 간의 이동 가능 유무를 판단하기 위해서는 바꿔야겠다고 생각함
		// A : 65, Z : 90, a : 97, z : 122
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				if(line.charAt(j) >= 'a') map[i][j] = line.charAt(j) - 71;
				else map[i][j] = line.charAt(j) - 'A';
			}
		}
		
		// 다익스트라로 풀기 위해서는
		// 1. 현 위치에서 갈 수 있는 다음 위치가 어디인지를 알아야하고
		// 2. 시작 지점에서부터 갈 수 있는 위치들까지 걸리는 최소 시간을 저장해야하고
		climbUpTime = new int[N][M];
		climbDownTime = new int[N][M];
		for(int i = 0; i < N; i++) {
			Arrays.fill(climbUpTime[i], INF);
		}
		
		
		
		climbUp(0);
//		System.out.println("등산");
//		for(int[] t : climbUpTime) {
//			System.out.println(Arrays.toString(t));
//		}
		
		int highest = 0;
		for(int i = 0; i < N*M; i++) {
			climbDown(i);
			
			int R = i / M;
			int C = i % M;
			
			if((climbUpTime[R][C] + climbDownTime[0][0]) >= 0 && (climbUpTime[R][C] + climbDownTime[0][0]) <= D && map[R][C] > highest) {
				highest = map[R][C];
			}
			
//			System.out.println(i + "에서 하산하면 " + (climbUpTime[R][C]+climbDownTime[0][0]) + "시간 소요");
//			for(int[] t : climbDownTime) {
//				System.out.println(Arrays.toString(t));
//			}
		}
		
		
		
		System.out.println(highest);
		
	} // end of main

	private static void climbDown(int departure) {
		for(int i = 0; i < N; i++) {
			Arrays.fill(climbDownTime[i], INF);
		}
		
		int R = departure/M;
		int C = departure%M;
		climbDownTime[R][C] = 0;
		
		boolean[][] isVisited = new boolean[N][M];
		
		for(int i = 0; i < lastPoint; i++) {
			int min = INF;
			int curr = -1;
			
			for(int j = 0; j < lastPoint; j++) {
				R = j / M;
				C = j % M;
				if(!isVisited[R][C] && climbDownTime[R][C] < min) {
					min = climbDownTime[R][C];
					curr = j;
				}
			}
			
			if(curr == -1) break;
			
			R = curr / M;
			C = curr % M;
			isVisited[R][C] = true;
			
			for(int d = 0; d < 4; d++) {
				int nr = R + dir[d][0];
				int nc = C + dir[d][1];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(!isVisited[nr][nc] && Math.abs(map[nr][nc] - map[R][C]) <= T) { // 아직 방문하지 않았고 두 지점의 높이 차가 T 이내이면 이동 가능
						if(map[nr][nc] > map[R][C]) { // 현 위치보다 높다면 두 위치의 높이의 차이의 제곱만큼 시간이 걸림
							if(climbDownTime[nr][nc] > climbDownTime[R][C] + Math.pow(map[nr][nc]-map[R][C], 2)) {
								climbDownTime[nr][nc] = (int) (climbDownTime[R][C] + Math.pow(map[nr][nc]-map[R][C], 2));
							}
						} else {
							if(climbDownTime[nr][nc] > climbDownTime[R][C] + 1) {
								climbDownTime[nr][nc] = climbDownTime[R][C] + 1;
							}
						}
					}
				}
			}			
		}
		
	}

	private static void climbUp(int point) {
		int R = point / M;
		int C = point % M;

		climbUpTime[R][C] = 0;
		
		boolean[][] isVisited = new boolean[N][M];
		
		for(int i = 0; i < N*M; i++) {
			int min = INF;
			int curr = -1;
			
			for(int j = 0; j < N*M; j++) {
				R = j / M;
				C = j % M;
				if(!isVisited[R][C] && climbUpTime[R][C] < min) {
					min = climbUpTime[R][C];
					curr = j;
				}
			}
			
			if(curr == -1) break;
			R = curr/M;
			C = curr%M;
			isVisited[R][C] = true;
			
			for(int d = 0; d < 4; d++) {
				int nr = R + dir[d][0];
				int nc = C + dir[d][1];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(!isVisited[nr][nc] && Math.abs(map[nr][nc] - map[R][C]) <= T) { // 아직 방문하지 않았고 두 지점의 높이 차가 T 이내이면 이동 가능
						if(map[nr][nc] > map[R][C]) { // 현 위치보다 높다면 두 위치의 높이의 차이의 제곱만큼 시간이 걸림
							if(climbUpTime[nr][nc] > climbUpTime[R][C] + Math.pow(map[nr][nc]-map[R][C], 2)) {
								climbUpTime[nr][nc] = (int) (climbUpTime[R][C] + Math.pow(map[nr][nc]-map[R][C], 2));
							}
						} else {
							if(climbUpTime[nr][nc] > climbUpTime[R][C] + 1) {
								climbUpTime[nr][nc] = climbUpTime[R][C] + 1;
							}
						}
					}
				}
			}
		}
	}
	
} // end of class
