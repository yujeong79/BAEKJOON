import java.io.*;
import java.util.*;

/**
 * 시작점하고 끝점을 모두 받아보자
 */

public class Main_BAEKJOON_17070_파이프옮기기1_Gold5 {	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int N;
	private static int[][] map;

	private static int answer;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Move(0, 1, 1);
		
		System.out.println(answer);
	} // end of main
	
	/**
	 * @param row
	 * @param column
	 * @param d : 방향, 1(가로), 2(세로), 3(대각선)
	 */
	private static void Move(int row, int column, int d) { 
		if(row == N-1 && column == N-1) {
			answer++;
			return;
		}
		
		if(d == 1 || d == 3) { // 가로 방향으로 가는 경우
			if(column + 1 < N && map[row][column+1] == 0)
				Move(row, column+1, 1);
		}
		
		if(d == 2 || d == 3) { // 세로 방향으로 가는 경우
			if(row + 1 < N && map[row+1][column] == 0)
				Move(row+1, column, 2);
		}
		
		if(d == 1 || d == 2 || d == 3) { // 대각선 방향으로 가는 경우
			if(row + 1 < N && column + 1 < N && map[row+1][column] == 0 && map[row][column+1] == 0 && map[row+1][column+1] == 0) {
				Move(row+1, column+1, 3);
			}
		}
	}
	
} // end of class
