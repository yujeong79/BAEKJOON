import java.io.*;
import java.util.*;

public class Main_BAEKJOON_14502_연구소_Gold4_000ms {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, M;
	static int[][] lab;
	  
	public static void main(String[] args) throws IOException {
		String size = br.readLine(); // 3 ≤ N, M ≤ 8
		N = size.charAt(0) - '0';
		M = size.charAt(2) - '0';
		
		lab = new int[N][M];
		for(int i = 0; i < N; i++) {
			String row = br.readLine();
			for(int j = 0, ci = 0; j < M; j++, ci+=2) {
				lab[i][j] = row.charAt(ci) - '0';
			}
		}
		
		BFS(0, 0);
		
	} // end of main

	private static void BFS(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(lab[i][j] == 0) {
					queue.add(new Point(i, j));
					break;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			
		}
	}
	
} // end of class
