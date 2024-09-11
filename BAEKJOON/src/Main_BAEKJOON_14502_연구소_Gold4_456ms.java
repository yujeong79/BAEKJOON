import java.io.*;
import java.util.*;

public class Main_BAEKJOON_14502_연구소_Gold4_456ms {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	
	static int N, M;
	static int[][] lab;
	static boolean[][] virus;
	static int answer;
	  
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
		
		answer = 0;
		backTracking(0, 0, 0);
		
		System.out.println(answer);
	} // end of main

	private static void backTracking(int r, int c, int wall) {
		if(c >= M) {
			backTracking(r+1, 0, wall);
			return;
		}
		
		
		if(wall >= 3) {
			virus = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(lab[i][j] == 2)
						BFS(i, j); // 벽 3개를 모두 세웠으면 바이러스 확산
				}
			}
			
			// 이렇게 세지 말고 처음부터 카운팅을 해서 빼기를 해보자
			int safeArea = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(!virus[i][j] && lab[i][j] == 0) safeArea++;
				}
			}
			
			answer = Math.max(answer, safeArea);
			return;
		}
		
		if(r >= N) {
			return;
		}
		
		int row = r; int column = c;
		while(row < N && column < M) {
			if(lab[row][column] == 0) { // 벽을 세울 수 있으면
				lab[row][column] = 1; // 벽을 세우고
				backTracking(row, column+1, wall+1); // 다음 backTracking
				
				lab[row][column] = 0; // 갔다오면 해당 자리는 다시 원상복구하고
			}
			
			// 해당 자리가 바이러스가 있거나 벽이 이미 존재하는 경우
			column++; // 다음 칸 살펴보기
			if(column == M) {
				row++; column = 0;
			}
		}
	}

	private static void BFS(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(r, c));
		virus[r][c] = true;
		
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int row = curr.r + dr[d];
				int column = curr.c + dc[d];
				if(row >= 0 && row < N && column >= 0 && column < M && lab[row][column] == 0 && !virus[row][column]) {
					queue.add(new Point(row, column));
					virus[row][column] = true;
				}
			}
		}
	}
	
} // end of class
