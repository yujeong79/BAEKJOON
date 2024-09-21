import java.io.*;
import java.util.*;

public class Main_BAEKJOON_4963_섬의개수_Silver2_128ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static final int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static final int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};
	
	static int h, w;
	static char[][] map;
	static boolean[][] isVisited;
	static int islands;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		while(w != 0 && h != 0) {
			map = new char[h][w];
			for(int i = 0; i < h; i++) {
				String str = br.readLine();
				for(int j = 0, ci = 0; j < w; j++, ci+=2) {
					map[i][j] = str.charAt(ci);
	 			}
			}
			
			islands = 0;
			isVisited = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == '1' && !isVisited[i][j]) {
						DFS(i, j);
						islands++;
					}
				}
			}
			
			sb.append(islands + "\n");
			
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void DFS(int i, int j) {
		isVisited[i][j] = true;
		
		for(int d = 0; d < 8; d++) {
			int r = i + dr[d];
			int c = j + dc[d];
			if(r >= 0 && r < h && c >= 0 && c < w && map[r][c] == '1' && !isVisited[r][c]) {
				DFS(r, c);
			}
		}
	}
	
	
} // end of class
