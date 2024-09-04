import java.io.*;
import java.util.*;

public class Main_BAEKJOON_2667_단지번호붙이기_Silver1 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	
	// 상 하 좌 우
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static int N;
	private static int[][] map;
	
	private static int cnt;
	private static List<Integer> answer;
	

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+2][N+2];
		for(int i = 1; i <= N; i++) {
			String row = br.readLine();
			for(int j = 1; j <= N; j++) {
				map[i][j] = row.charAt(j-1) - '0';
			}
		}
		
		answer = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(map[i][j] != 0) {
					cnt = 0; // 각 단지에 속하는 집의 수
					DFS(i, j);
					answer.add(cnt);
				}
			}
		}
		
		sb.append(answer.size() + "\n");
		for(int n : answer) {
			sb.append(n + "\n");
		}
		System.out.println(sb);
	} // end of main

	private static void DFS(int i, int j) {
		map[i][j] = 0; cnt++;
		
		for(int d = 0; d < 4; d++) {
			if(map[i+dr[d]][j+dc[d]] != 0) {
				DFS(i+dr[d], j+dc[d]);
			}
		}
		
	}
	
} // end of class
