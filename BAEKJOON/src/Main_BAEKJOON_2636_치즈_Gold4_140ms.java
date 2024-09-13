import java.io.*;
import java.util.*;

public class Main_BAEKJOON_2636_치즈_Gold4_140ms {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static final int[] dr = {-1, 0, 1, 0};
	static final int[] dc = {0, 1, 0, -1};
	
	static int N, M;
	static char[][] cheese;
	static boolean[][] isVisited;
	
	static int cheeseCnt = 0;
	static int lastCheeseCnt = 0;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 세로 길이
		M = Integer.parseInt(st.nextToken()); // 가로 길이
		
		cheese = new char[N][M];
		for(int i = 0; i < N; i++) { // 치즈 입력 받기
			String str = br.readLine();
			for(int j = 0, ci = 0; j < M; j++, ci+=2) {
				cheese[i][j] = str.charAt(ci);
				if(cheese[i][j] == '1') cheeseCnt++;
			}
		}
		
		int time = 0;
		
		while(cheeseCnt > 0) {
			time++;
			isVisited = new boolean[N][M];
			BSF(N-1, M-1);
		}
		
		sb.append(time + "\n" + lastCheeseCnt);
		System.out.println(sb);
	} // end of main

	private static void BSF(int i, int j) {
		int currCheeseCnt = cheeseCnt;
		
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(i, j));
		isVisited[i][j] = true;
		
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int r = curr.r + dr[d];
				int c = curr.c + dc[d];
				
				if(r >= 0 && r < N && c >= 0 && c < M && !isVisited[r][c]) {
					if(cheese[r][c] == '1') {
						isVisited[r][c] = true;
						cheese[r][c] = '0'; // 먹기
						cheeseCnt--;
					} else {
						queue.add(new Point(r, c));
						isVisited[r][c] = true;
					}
				}
			}
		}
		
		if(cheeseCnt == 0) lastCheeseCnt = currCheeseCnt;
	}
	
} // end of class
