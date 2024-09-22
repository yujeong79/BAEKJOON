import java.io.*;
import java.util.*;


public class Main_BAEKJOON_7576_토마토_Gold5_544ms {
	static class Point {
		int r, c, day;

		public Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.day = d; // 현재 토마토가 며칠이 지나면 익는지 Point에 저장
		}

		@Override
		public String toString() {
			return "(" + r + ", " + c + ")";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	
	static int N, M, qSize, ripen, unripen, empty, answer;
	static int[][] box;
	static boolean[][] isVisited;
	
	static int[][] dayStorage;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		ripen = unripen = empty = 0;
		isVisited = new boolean[N][M];
		answer = 0;
		
		box = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) ripen++; // 익은 토마토의 수
				else if(box[i][j] == 0) unripen++; // 익지 않은 토마토의 수
				else empty++; // 토마토가 들어있지 않은 칸의 수
			}
		}
		
		
		if(ripen == N*M - empty) System.out.println(0); // 모든 토마토가 익어 있으면 0 출력
		else {
			BFS();
	
			if(unripen >= 1) System.out.println(-1); // 익지 않은 토마토가 남아있는 경우 -1 출력
			else System.out.println(answer);
		}
		
	} // end of main

	private static void BFS() {
		Queue<Point> queue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 1) { // 익은 토마토의 모든 위치를 queue에 저장
					queue.add(new Point(i, j, 0));
					isVisited[i][j] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point curr = queue.poll(); // 익은 토마토 꺼내서
			
			for(int d = 0; d < 4; d++) {
				int r = curr.r + dr[d];
				int c = curr.c + dc[d];
				if(r >= 0 && r < N && c >= 0 && c < M && box[r][c] == 0 && !isVisited[r][c]) {
					queue.add(new Point(r, c, curr.day+1)); // 인접한 칸의 익지 않은 토마토를 curr.day+1해서 queue에 넣기, 
					answer = Math.max(answer, curr.day+1); // 최소일수 갱신
					box[r][c] = 1; // 현재 토마토가 익게 됨
					unripen--; // 익지 않은 토마토의 수 1 감소
					isVisited[r][c] = true;
				}
			}
			
		}
	}
	
} // end of class
