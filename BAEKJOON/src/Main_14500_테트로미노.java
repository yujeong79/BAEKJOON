import java.io.*;
import java.util.*;

public class Main_14500_테트로미노 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, answer;
	static int[][] map;
	static boolean[][] isSelected;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		isSelected = new boolean[N][M];

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				isSelected[i][j] = true;
				DFS(i, j, 1, map[i][j]);
				BFS(i, j);

				isSelected[i][j] = false;
			}
		}
		
		System.out.println(answer);
		
	} // end of main

	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	/**
	 * @param point : 현지점
	 * @param count : 선택된 칸의 개수
	 */
	private static void DFS(int r, int c, int count, int sum) {
		if(count >= 4) {
			answer = Math.max(answer, sum);
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !isSelected[nr][nc]) { // 범위 내에 있으면
				isSelected[nr][nc] = true;
				DFS(nr, nc, count + 1, sum + map[nr][nc]);

				isSelected[nr][nc] = false;
			}
		}
	}

	private static void BFS(int r, int c) {
		int sum = map[r][c];
		int cnt = 1; // 선택된 칸의 개수

		Stack<Integer> stack = new Stack<>();

		for(int d = 0; d < 4; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];

			if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
				sum += map[nr][nc];
				stack.push(map[nr][nc]);
				cnt++;
			}
		}

		if(cnt == 4) answer = Math.max(answer, sum);
		else if(cnt < 4) return;
		else {
			while(!stack.empty()) {
				answer = Math.max(answer, sum - stack.pop());
			}
		}
	}
	
} // end of class
