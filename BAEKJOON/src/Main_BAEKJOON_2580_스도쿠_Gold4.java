import java.io.*;
import java.util.*;

public class Main_BAEKJOON_2580_스도쿠_Gold4 {
	private static StringBuilder sb = new StringBuilder();
	
	private static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[9][9];
		for(int i = 0; i < 9; i++) { // 보드판 채우기
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		backTracking(0, 0);
		
	} // end of main

	private static void backTracking(int r, int c) {
		if(c >= 9) {
			backTracking(r+1, 0);
			return;
		}
		
		if(r >= 9) {
			for(int[] b : board) {
				for(int n : b) sb.append(n + " ");
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
			return;
		}
		

		if(board[r][c] == 0) {
			for(int n = 1; n <= 9; n++) {
				if(isPromising(r, c, n)) { // n이 들어갈 수 있는지 유망성 확인
					board[r][c] = n;
					backTracking(r, c+1);
				}
			}
			board[r][c] = 0;
			return;
		}
		backTracking(r, c+1);
	}

	private static boolean isPromising(int r, int c, int n) {
		
		for(int i = 0; i < 9; i++) { 
			if(board[i][c] == n) return false; // 같은 열에 n이 있는지 확인
			if(board[r][i] == n) return false; // 같은 행에 n이 있는지 확인
		}
		
		int row = r - r%3; int rEnd = row+3;
		int column = c - c%3; int cEnd = column+3;
		for(int i = row; i < rEnd; i++) {
			for(int j = column; j < cEnd; j++) {
				if(board[i][j] == n) return false;
			}
		}
		
		return true;
	}
	
} // end of class	
