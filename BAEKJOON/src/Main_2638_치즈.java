import java.io.*;
import java.util.*;

/**
 * 치즈의 수가 0이 될 때까지 BFS를 반복한다.
 * 	가장자리에서부터 탐색해 BFS의 Queue에는 치즈가 아닌 공기의 좌표(0)만 담는다.	
 * 	치즈가 아닌 자리를 탐색하다 치즈(1)를 만나면 외부 공기와의 접촉 면의 수(즉, 방문 횟수)를 1 증가시키고, 접촉면의 수(방문 횟수)가 2 이상이 되면 해당 좌표의 치즈를 0으로 바꾼다.		
 */

public class Main_2638_치즈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, cheeseCnt, time;
	static char[][] cheese; 
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cheese = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0, cIdx = 0; j < M; j++, cIdx+=2) {
				cheese[i][j] = str.charAt(cIdx);
				if(cheese[i][j] == '1') cheeseCnt++; // 초기 치즈의 수를 세어놓는다.	
			}
		}
		
		while(cheeseCnt > 0) { // 치즈가 모두 녹아 없어질 때까지 BFS를 실행한다.	
			BFS();
			time++; // BFS를 한 번 돌릴 때마다 1시간씩
		}
		
		System.out.println(time);
		
	} // end of main

	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	private static void BFS() {
		int[][] visitCnt = new int[N][M]; // 외부 공기와 접촉면의 수를 저장한다.
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {0, 0}); // 시작 위치는 항상 (0, 0)이다.
		visitCnt[0][0] = 2; // 외부 공기와의 접촉 면이 2개 이상인 경우에 치즈가 녹으니(0) 치즈가 없는 공간의 방문 표시는 2로 해두자.
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = curr[0] + dir[d][0];
				int nc = curr[1] + dir[d][1];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && visitCnt[nr][nc] < 2) {
					if(cheese[nr][nc] == '1') { // 해당 칸이 치즈라면
						visitCnt[nr][nc]++; // 방문 횟수 1 증가시킨다.
						
						if(visitCnt[nr][nc] >= 2) { // 외부 공기와의 접촉면이 2개 이상이면 
							cheese[nr][nc] = '0'; // 치즈가 녹는다.	
							cheeseCnt--; // 전체 치즈의 수를 1 감소시킨다.
						}
					} else { // 해당 칸이 공기라면
						visitCnt[nr][nc] = 2;
						queue.add(new int[] {nr, nc}); // 큐에 담는다.
					}
				}
			}
		}
	}
	
} // end of class
