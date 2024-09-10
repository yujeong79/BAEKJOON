import java.io.*;
import java.util.*;

public class Main_BAEKJOON_21610_마법사상어와비바라기_Gold5_228ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static final int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static final int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	static int N, M;
	static int[][] map;
	static boolean[][] cloud;
	static boolean[][] temp;
	static int d, s;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // N*N 크기의 격자 
		M = Integer.parseInt(st.nextToken()); // M번의 이동
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 초기 구름 생성
		cloud = new boolean[N][N];
		cloud[N-1][0] = cloud[N-1][1] = cloud[N-2][0] = cloud[N-2][1] = true;
		
		for(int i = 0; i < M; i++) { // M번의 이동을 받아와서
			st = new StringTokenizer(br.readLine(), " ");
			d = Integer.parseInt(st.nextToken())-1;
			s = Integer.parseInt(st.nextToken());
			
			temp = new boolean[N][N];
			moveCloud(d, s); // 구름 이동
		}
		
		int answer = 0;
		for(int[] m : map) {
			for(int n : m) answer += n;
		}
		
		System.out.println(answer);
	} // end of main

	private static void moveCloud(int direction, int distance) {
		// 모든 격자를 확인하며 구름이 있는 경우 distance만큼 구름 옮기기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(cloud[i][j]) { // 구름이 있으면
					//System.out.println(i + ", " + j);
					int cnt = 0;
					int row = i; int column = j;
					while(++cnt <= distance) { // distance만큼 이동하기
						row += dr[direction];
						column += dc[direction];
						
						if(row < 0) {
							row = N-1;
						} else if(row >= N) {
							row = 0;
						}
						
						if(column < 0) {
							column = N-1;
						} else if(column >= N) {
							column = 0;
						}
					}
					
					temp[row][column] = true; // 1. 모든 구름이 d방향으로 s칸 이동
					map[row][column]++; // 2. 구름이 있는 칸의 바구니 물 양 1 증가
				}
			}
		}
		
		
		// 3. 구름이 사라진다(그러나 5를 위해 현재 구름이 있는 칸을 기억해두어야 하므로 현재 단계에서 없애지 않는다.)
		// 4. 구름이 있는 칸에 물복사버그 마법을 시전한다.
		BugMagic();
		
		// 5. 물의 양이 2 이상인 모든 칸에 구름 생성하고 물의 양 2 감소
		cloud = new boolean[N][N]; // 새로운 구름을 생성하기 위하여 기존의 구름 배열 초기화
		CreateCloud();
	}

	private static void CreateCloud() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] >= 2 && !temp[i][j]) {
					cloud[i][j] = true;
					map[i][j] -= 2;
				}
			}
		}
	}

	private static void BugMagic() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(temp[i][j]) { // 구름이 있으면 2에서 증가했으므로 물복사버그 마법을 시전
					int cnt = 0;
					for(int k = 1; k < 8; k+=2) { // 대각선만 탐색
						int row = i + dr[k];
						int column = j + dc[k];
						if(row >= 0 && row <= N-1 && column >= 0 && column <= N-1) { // 범위 내에 있는 경우
							if(map[row][column] > 0) cnt++;
						}
					}
					map[i][j] += cnt;
				}
			}
		}
	}
	
} // end of class
