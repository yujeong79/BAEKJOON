import java.io.*;
import java.util.*;

public class Main_BAEKJOON_10026_적록색약_Gold5_136ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int N;
	static char[][] drawing;
	static boolean[][] isVisited;
	
	static int area1, area2;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		drawing = new char[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			drawing[i] = str.toCharArray();
		}
		
		isVisited = new boolean[N][N];
		area1 = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!isVisited[i][j]) {
					DFS1(i, j);
					area1++;
				}
			}
		}
		
		isVisited = new boolean[N][N];
		area2 = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!isVisited[i][j]) {
					DFS2(i, j);
					area2++;
				}
			}
		}
		
		System.out.println(area1 + " " + area2);
	} // end of main

	private static void DFS1(int i, int j) {
		isVisited[i][j] = true;
		
		for(int d = 0; d < 4; d++) {
			int r = i + dir[d][0];
			int c = j + dir[d][1];
			if(r >= 0 && r < N && c >= 0 && c < N && drawing[i][j] == drawing[r][c] && !isVisited[r][c]) {
				DFS1(r, c);
			}
		}
	}
	
	private static void DFS2(int i, int j) {
		isVisited[i][j] = true;
		
		for(int d = 0; d < 4; d++) {
			int r = i + dir[d][0];
			int c = j + dir[d][1];
			if(r >= 0 && r < N && c >= 0 && c < N && !isVisited[r][c]) {
				if((drawing[i][j] == 'R' || drawing[i][j] == 'G') && (drawing[r][c] == 'R' || drawing[r][c] == 'G'))
					DFS2(r, c);
				else if(drawing[i][j] == 'B' && drawing[r][c] == 'B') {
					DFS2(r, c);
				}
			}
		}
	}
} // end of class
