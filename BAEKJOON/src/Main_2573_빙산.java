import java.io.*;
import java.util.*;

/**
 * 1년 마다 빙산을 녹이고 => findIceberg와 melt 메서드
 * 빙산 덩어리의 수를 세기 => countArea와 BFS 메서드	
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
		iceberg = new boolean[N][M]; // 해당 좌표가 빙산인지 아닌지를 저장하는 2차원 배열
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) {
					icebergCnt++; // 빙산의 수 세기
					iceberg[i][j] = true; // 해당 좌표가 빙산이면 true
				}
			}
		}
		
		year = 0;
		isDivided = false; // 빙산 덩어리의 수가 1개이면 false, 2 덩어리 이상이면 true
		
		countArea(); // 첫 상태부터 두 덩어리일 수도 있으니까 덩어리 수를 먼저 세어본다.
		
		while(!isDivided && icebergCnt > 0) { // 두 덩어리로 나뉘어졌거나 모든 빙산이 다 녹을 때까지 반복
			
			findIceberg(); // 빙산을 찾아 녹인다.
			
			if(icebergCnt > 0) { // 빙산이 이미 다 녹은 경우 덩어리를 세지 않는다. (반례)
				countArea();
				year++;
			}
			
		}
		
		if(icebergCnt == 0 && !isDivided) System.out.println(0); // 빙산 덩어리가 2개 이상이 아니지만 모든 빙산이 다 녹은 경우
		else System.out.println(year);
		
	} // end of main
	
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	private static void countArea() {
		int cnt = 0;
		isVisited = new boolean[N][M];
		
		for(int i = 1; i < N-1; i++) {
			for(int j = 1; j < M-1; j++) {
				if(map[i][j] > 0 && !isVisited[i][j]) {
					
					if(cnt >= 1) { // BFS를 이미 한 번 돌린 상태라는 것은 빙산 덩어리가 2개 이상이라는 것
						isDivided = true;
						return;
					}
					
					BFS(i, j);
					cnt++;
				} else if(map[i][j] == 0 && iceberg[i][j]) { // melt를 통해 빙산이 다 녹았으면 해당 좌표를 false로 변경
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
				if(map[i][j] > 0) { // 해당 좌표가 빙산이라면 빙산 녹이기
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
		if(map[r][c] == 0) icebergCnt--; // 빙하가 다 녹았다면 빙산의 수 1 감소
	}

	
} // end of class
