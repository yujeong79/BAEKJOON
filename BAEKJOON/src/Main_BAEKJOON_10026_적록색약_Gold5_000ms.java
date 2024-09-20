import java.io.*;
import java.util.*;

public class Main_BAEKJOON_10026_적록색약_Gold5_000ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int N;
	static char[][] drawing;
	static boolean[][] isVisited;
	
	static int ;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		drawing = new char[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			drawing[i] = str.toCharArray();
		}
		
		area = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!isVisited[i][j]) {
					DFS(i, j);
					area++;
				}
			}
		}
		
	} // end of main

	private static void DFS(int i, int j) {
		isVisited[i][j] = true;
		
		for(int d = 0; d < 4; d++) {
			int r = i + dir[d][0];
			int c = j + dir[d][1];
			if(r >= 0 && r < N && c >= 0 && c < N && drawing[i][j] == drawing[r][c] && !isVisited[r][c]) {
				DFS(r, c);
			}
		}
		
	}
	
} // end of class
