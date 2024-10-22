import java.io.*;
import java.util.*;

/**
 * 1년 마다 빙산을 녹이는 메서드와 BFS	
 */

public class Main_2573_빙산 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, year, icebergCnt;
	static int[][] map;
	static boolean[][] iceberg, isVisited;
	static boolean isDivided;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 3 <= N, M <= 300
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		iceberg = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) {
					icebergCnt++;
					iceberg[i][j] = true; // 해당 좌표가 빙산이면 true
				}
			}
		}
		
		year = 0;
		isDivided = false;
		
		countArea();
		
		while(!isDivided && icebergCnt > 0) {
//			System.out.println(icebergCnt);
			
			findIceberg();
			
//			for(int[] m : map) {
//				System.out.println(Arrays.toString(m));
//			}
			
//			System.out.println(icebergCnt);
			if(icebergCnt > 0) {
				countArea();
				year++;
			}
			
		}
		
		if(icebergCnt == 0 && !isDivided) System.out.println(0);
		else System.out.println(year);
		
	} // end of main
	
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	private static void countArea() {
		int cnt = 0;
		isVisited = new boolean[N][M];
		
		for(int i = 1; i < N-1; i++) {
			for(int j = 1; j < M-1; j++) {
				if(map[i][j] > 0 && !isVisited[i][j]) {
					
					if(cnt >= 1) {
						isDivided = true;
						return;
					}
					
					BFS(i, j);
					cnt++;
				} else if(map[i][j] == 0 && iceberg[i][j]) { // 빙산이 다 녹았으면 해당 좌표를 false로 변경
					iceberg[i][j] = false;
				}
			}
		}
		
	}

	private static void BFS(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {r, c});
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = curr[0] + dir[d][0];
				int nc = curr[1] + dir[d][1];
				
				if(map[nr][nc] > 0 && !isVisited[nr][nc]) {
					queue.add(new int[] {nr, nc});
					isVisited[nr][nc] = true;
				}
			}
		}
		
	}

	private static void findIceberg() {
		for(int i = 1; i < N-1; i++) {
			for(int j = 1; j < M-1; j++) {
				if(map[i][j] > 0) { // 해당 좌표가 빙산이라면 바닷물이 접해있는 부분 세기
					melt(i, j);
				}
			}
		}
	}

	private static void melt(int r, int c) {
		for(int d = 0; d < 4; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			
			if(map[nr][nc] == 0 && !iceberg[nr][nc]) { // 인접한 좌표가 바다라면, 기존 빙하였던 자리가 0이 되어 바다와 구분이 되지 않는 것을 방지하기 위해서 iceberg 배열 사용
				if(map[r][c] > 0)
					map[r][c]--;
				
			}
		}
		if(map[r][c] == 0) icebergCnt--;
	}

	
} // end of class
