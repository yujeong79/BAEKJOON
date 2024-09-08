import java.io.*;
import java.util.*;

public class Main_BAEKJOON_9663_NQueen_Gold4 {
	private static int count;
	private static int N;
	private static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // N * N 체스판 위에 N개의 퀸을 서로 공격할 수 없게 놓기
		
		board = new int[N][N];
		
		count = 0;
		backTracking(0);
		
		System.out.println(count);
		
	} // end of main

	private static void backTracking(int r) {
		
		if(r == N) {
			count++;
			return;
		}
		
		for(int c = 0; c < N; c++) {
			if(isPromising(r, c)) {
				board[r][c] = 1;
				backTracking(r+1);
				board[r][c] = 0;
			}
		}
	}

	private static boolean isPromising(int r, int c) {
		
		// 같은 열 탐색
		for(int i = 0; i < N; i++) {
			if(board[i][c] != 0) return false;
		}
		
		// 왼쪽 상 탐색
		int row = r; int column = c;
		while(row >= 0 && column >= 0) {
			if(board[row][column] != 0) return false;
			row--;
			column--;
		}
		
		// 오른쪽 상 탐색
		row = r; column = c;
		while(row >= 0 && column <= N-1) {
			if(board[row][column] != 0) return false;
			row--;
			column++;
		}
		
		return true;
	}
	
	
} // end of class
