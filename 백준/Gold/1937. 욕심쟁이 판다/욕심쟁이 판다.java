import java.util.*;
import java.io.*;

/*
 * 1937. 욕심쟁이 판다
 * 현재 위치보다 더 많은 대나무가 있는 위치로만 이동 가능
 * 어떤 지점에 처음에 풀어 놓아야 하고, 어떤 곳으로 이동을 시켜야 판다가 최대한 많은 칸을 방문할 수 있을지 구하기
 */

public class Main {
	static int n;
	static int[][] map, memo;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 초기화
		int answer = 0;
		n = Integer.parseInt(br.readLine()); // 1 ≤ n ≤ 500
		map = new int[n][n];
		memo = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				memo[i][j] = -1;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(memo[i][j] == -1) answer = Math.max(answer, dfs(i, j));
				else answer = Math.max(answer, memo[i][j]);
			}
		}
		
		System.out.println(answer);
		
	}
	
	public static int dfs(int r, int c) {
//		if(memo[r][c] >= 0) {
//			return memo[r][c];
//		}
		
		boolean isMovable = false; // 현재 위치에서 이동할 수 있는 칸이 있는지 여부
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			
			if(nr < 0 || nr >= n || nc < 0 || nc >= n || map[r][c] >= map[nr][nc]) 
				continue;
			
			isMovable = true;
			memo[r][c] = Math.max(memo[r][c], memo[nr][nc] > 0 ? memo[nr][nc] + 1 : dfs(nr, nc) + 1);
		}
		
		if(!isMovable) {
			memo[r][c] = 1;
			return memo[r][c];
		}
		
		return memo[r][c];
	}
	
}