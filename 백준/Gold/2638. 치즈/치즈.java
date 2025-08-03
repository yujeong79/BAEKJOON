import java.io.*;
import java.util.*;

public class Main {
	static int N, M, cheeseCnt, time;
	static char[][] cheese; 
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cheese = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0, cIdx = 0; j < M; j++, cIdx+=2) {
				cheese[i][j] = str.charAt(cIdx);
				if(cheese[i][j] == '1') cheeseCnt++;	
			}
		}
		
		while(cheeseCnt > 0) {
			BFS();
			time++;
		}
		
		System.out.println(time);
		
	}
	
	private static void BFS() {
		int[][] visitCnt = new int[N][M];
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {0, 0});
		visitCnt[0][0] = 2;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = curr[0] + dir[d][0];
				int nc = curr[1] + dir[d][1];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && visitCnt[nr][nc] < 2) {
					if(cheese[nr][nc] == '1') {
						visitCnt[nr][nc]++;
						
						if(visitCnt[nr][nc] >= 2) {
							cheese[nr][nc] = '0';
							cheeseCnt--;
						}
					} else {
						visitCnt[nr][nc] = 2;
						queue.add(new int[] {nr, nc});
					}
				}
			}
		}
	}
	
} // end of class