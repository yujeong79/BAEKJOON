import java.io.*;
import java.util.*;

public class Main {
	static char[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String input = br.readLine();
			if(input.equals("end")) {
				break;
			}
			
			board = new char[3][3];
			int X = 0;
			int O = 0;
			int empty = 0;
			
			for(int i = 0; i < 9; i++) {
				board[i/3][i%3] = input.charAt(i);
				
				switch(board[i/3][i%3]) {
				case 'X':
					X++;
					break;
				case 'O':
					O++;
					break;
				default :
					empty++;
					break;
				}
			}
			
			if(empty % 2 != 0 && X != O || empty % 2 == 0 && X-1 != O) {
				sb.append("invalid").append("\n");
				continue;
			}
			
			boolean xFlag = false;
			boolean oFlag = false;
			
			// 행 탐색 
			for(int r = 0; r < 3; r++) {
				char curr = board[r][0];
				if(curr == '.' || curr == 'X' && xFlag || curr == 'O' && oFlag) 
					continue;
				
				boolean flag = true;
				for(int c = 1; c < 3; c++) {
					if(curr != board[r][c]) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					if(curr == 'X') xFlag = true;
					else oFlag = true;
				}
			}
			
			// 열 탐색
			for(int c = 0; c < 3; c++) {
				char curr = board[0][c];
				if(curr == '.' || curr == 'X' && xFlag || curr == 'O' && oFlag) 
					continue;
				
				boolean flag = true;
				for(int r = 1; r < 3; r++) {
					if(curr != board[r][c]) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					if(curr == 'X') xFlag = true;
					else oFlag = true;
				}
			}
			
			// 대각선 탐색
			char curr = board[0][0];
			boolean flag = true;
			if(curr != '.' || curr == 'X' && !xFlag || curr == 'O' && !oFlag) {
				for(int i = 1; i < 3; i++) {
					if(curr != board[i][i]) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					if(curr == 'X') xFlag = true;
					else oFlag = true;
				}
			}
			
			curr = board[2][0];
			flag = true;
			if(curr != '.' || curr == 'X' && !xFlag || curr == 'O' && !oFlag) {
				for(int i = 1; i < 3; i++) {
					if(curr != board[2-i][i]) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					if(curr == 'X') xFlag = true;
					else oFlag = true;
				}
			}
			
			if(empty % 2 != 0 && !xFlag && oFlag) {
				sb.append("valid").append("\n");
			} else if(empty % 2 == 0 && xFlag && !oFlag) {
				sb.append("valid").append("\n");
			} else if(empty == 0 && !oFlag) {
				sb.append("valid").append("\n");
			} else {
				sb.append("invalid").append("\n");
			}
			
		} // end of testcase
		
		System.out.println(sb);
	}
}