import java.io.*;
import java.util.*;

public class Main_BAEKJOON_2178_미로탐색_Silver1_108ms {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "(" + r + ", " + c + ")";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	
	static int N, M;
	static char[][] map;
	static boolean[][] isVisited;
	static int[][] dist;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dist = new int[N][M];
		isVisited = new boolean[N][M];
		
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String row = br.readLine();
			map[i] = row.toCharArray();
		}
		
		BFS(0, 0);
		
		System.out.println(dist[N-1][M-1]);
		
	} // end of main

	private static void BFS(int i, int j) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(i, j));
		dist[i][j] = 1;
		isVisited[i][j] = true;
		
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int r = curr.r + dr[d];
				int c = curr.c + dc[d];
				if(r >= 0 && r < N && c >= 0 && c < M && map[r][c] == '1' && !isVisited[r][c]) {
					queue.add(new Point(r, c));
					dist[r][c] = dist[curr.r][curr.c] + 1;
					isVisited[r][c] = true;
				}
			}
		}
	}
	
} // end of class
