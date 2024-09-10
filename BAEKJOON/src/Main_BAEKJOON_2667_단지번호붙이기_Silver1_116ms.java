import java.io.*;
import java.util.*;

public class Main_BAEKJOON_2667_단지번호붙이기_Silver1_116ms {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	
	static int N;
	static char[][] map;
	static boolean[][] isVisited;
	static List<Integer> homeList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		isVisited = new boolean[N][N];
		
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			String row = br.readLine();
			map[i] = row.toCharArray();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == '1' && !isVisited[i][j]) 
					homeList.add(BFS(i, j));
			}
		}
		
		Collections.sort(homeList);
		sb.append(homeList.size() + "\n");
		for(int n : homeList) {
			sb.append(n + "\n");
		}
		
		System.out.println(sb);
	} // end of main

	private static int BFS(int i, int j) {
		int count = 0;
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(i, j));
		isVisited[i][j] = true;
		count++;
		
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int r = curr.r + dr[d];
				int c = curr.c + dc[d];
				if(r >= 0 && r < N && c >= 0 && c < N && map[r][c] == '1' && !isVisited[r][c]) {
					queue.add(new Point(r, c));
					isVisited[r][c] = true;
					count++;
				}
			}
		}
		
		return count;
	}
	
} // end of class
