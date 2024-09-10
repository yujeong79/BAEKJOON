import java.io.*;
import java.util.*;

/**
 * 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 토마토가 들어있지 않은 칸
 * 저장될 때부터 모든 토마토가 익어 있으면 0을 출력, 토마토가 모두 익지 못하는 상황이면 -1 출력
 */

public class Main_BAEKJOON_7576_토마토_Gold5_544ms {
	static class Point {
		int r, c, day;

		public Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.day = d;
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
	static int[][] box;
	static boolean[][] isVisited;
	static int qSize;
	
	static int ripen;
	static int unripen;
	static int empty;
	
	static int answer = 0;
	
	static int[][] dayStorage;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		ripen = 0; unripen = 0; empty = 0;
		isVisited = new boolean[N][M];
		
		box = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) ripen++;
				else if(box[i][j] == 0) unripen++;
				else empty++; 
			}
		}
		
		if(ripen == N*M - empty) System.out.println(0);
		else {
			BFS();
	
			if(unripen >= 1) System.out.println(-1);
			else System.out.println(answer);
		}
		
	} // end of main

	private static void BFS() {
		Queue<Point> queue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 1) {
					queue.add(new Point(i, j, 0));
					isVisited[i][j] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int r = curr.r + dr[d];
				int c = curr.c + dc[d];
				if(r >= 0 && r < N && c >= 0 && c < M && box[r][c] == 0 && !isVisited[r][c]) {
					queue.add(new Point(r, c, curr.day+1));
					answer = Math.max(answer, curr.day+1);
					box[r][c] = 1;
					unripen--;
					isVisited[r][c] = true;
				}
			}
			
		}
	}
	
} // end of class
