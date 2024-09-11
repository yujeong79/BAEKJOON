import java.io.*;
import java.util.*;

public class Main_BAEKJOON_17836_공주님을구해라_Gold5_104ms {
	static class Point {
		int r, c, time;

		public Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	
	static int N, M, T;
	static char[][] map;
	static boolean[][] isVisited;
	
	static boolean hasSword;
	static int[][] timeStorage; 
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String row = br.readLine();
			for(int j = 0, ci = 0; j < M; j++, ci += 2) {
				map[i][j] = row.charAt(ci);
			}
		}
		
		hasSword = false;
		timeStorage = new int[N][M];
		isVisited = new boolean[N][M];
		
		BFS();
		
		System.out.println(timeStorage[N-1][M-1] <= T && timeStorage[N-1][M-1] != 0 ? timeStorage[N-1][M-1] : "Fail");
	
	} // end of main

	private static void BFS() {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(0, 0, 0));
		isVisited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			
			if(map[curr.r][curr.c] == '2') {
				hasSword = true;
				int hour = 0;
				int r  = curr.r; int c = curr.c;
				while(r < N-1) {
					r++; hour++;
				}
				while(c < M-1) {
					c++; hour++;
				}
				
				if(timeStorage[r][c] != 0) timeStorage[r][c] = Math.min(curr.time + 1, timeStorage[r][c]);
				else timeStorage[r][c] = curr.time + hour;
			}
			
			for(int d = 0; d < 4; d++) {
				int r = curr.r + dr[d];
				int c = curr.c + dc[d];
				
				if(r >= 0 && r < N && c >= 0 && c < M && !isVisited[r][c] && map[r][c] != '1') {
					if(curr.time + 1 > T) return;
					queue.add(new Point(r, c, curr.time + 1));
					if (r == N-1 && c == M-1) {
						//System.out.println(curr.time + 1);
						if(timeStorage[r][c] != 0) timeStorage[r][c] = Math.min(curr.time + 1, timeStorage[r][c]);
						else timeStorage[r][c] = curr.time + 1;
					} else timeStorage[r][c] = curr.time+1;
					isVisited[r][c] = true;	
				}
				
			}
			
//			for(int[] t : timeStorage) {
//				System.out.println(Arrays.toString(t));
//			}
//			System.out.println();
		}
	}
	
} // end of class
