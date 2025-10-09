import java.util.*;
import java.io.*;

public class Main {
	static int N, M, answer;
	static int[][] map;
	static int[][] isVisited;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 1 ≤ N ≤ 1,000
		M = Integer.parseInt(st.nextToken()); // 1 ≤ M ≤ 1,000
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			
			for(int j = 0; j < M; j++) {
				switch (input.charAt(j)) {
				case 'U':
					map[i][j] = 0;
					break;
				case 'D':
					map[i][j] = 1;
					break;
				case 'L':
					map[i][j] = 2;
					break;
				case 'R':
					map[i][j] = 3;
					break;
				}
			}
		}
		
		int round = 0;
		isVisited = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(isVisited[i][j] == 0) {
					dfs(i, j, ++round);
				}
			}
		}
		
		System.out.println(answer);
		
	}
	
	public static void dfs(int r, int c, int round) {
		isVisited[r][c] = round; // 몇번째 라운드에 방문하였는지 확인
		
		int d = map[r][c];
		int nr = r + dir[d][0];
		int nc = c + dir[d][1];
		
		if(isVisited[nr][nc] == 0) dfs(nr, nc, round);
		else {
			if(isVisited[nr][nc] == round) {
				answer++;
				return;
			} else {
				return;
			}
		}
	}
}