import java.io.*;
import java.util.*;

public class Main_BAEKJOON_2667_단지번호붙이기_Silver1 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	// 상 하 좌 우
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static int N;
	private static int[][] map;
	
	private static List<Integer> answer;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+2][N+2];
		for(int i = 1; i <= N; i++) {
			String row = br.readLine();
			for(int j = 1; j <= N; j++) {
				map[i][j] = row.charAt(j) - '0';
			}
		}
		
		answer = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(map[i][j] != 0)
					BFS(i, j);	
			}
		}
		
		System.out.println(answer.toString());
		
	} // end of main

	private static void BFS(int i, int j) {
		int[] start = {i, j};
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(start);
		map[i][j] = 0;
		int length = 1;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];
			if(map[r+dr[0]][c+dc[0]] != 0 || map[r+dr[1]][c+dc[1]] != 0 || map[r+dr[2]][c+dc[2]] != 0 || map[r+dr[3]][c+dc[3]] != 0) {
				for(int d = 0; d < 4; d++) {
					if(map[r+dr[i]][c+dc[i]] != 0) {
						int[] adj = {r+dr[i], c+dc[i]};
						queue.add(adj); length++;
						map[r+dr[i]][c+dc[i]] = 0;
					}
				}
			}
		}
		
		answer.add(length);
		
	} // end of main
} // end of class
