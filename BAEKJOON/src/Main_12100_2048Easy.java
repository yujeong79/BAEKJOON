import java.io.*;
import java.util.*;

/**
 * 
 */

public class Main_12100_2048Easy {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int N;
	static int[][] board;
	
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); //  (1 ≤ N ≤ 20)
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = new int[5]; // 방향 조합을 저장할 배열
		perm(0);
		
	} // end of main

	private static void perm(int cnt) { // 가능한 방향 조합을 모두 찾기
		if(cnt >= 5) {
			play();
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			result[cnt] = i;
			perm(cnt+1);
		}
	}

	private static void play() {
		for(int i = 0; i < 5; i++) {
			int d = result[i]; // 현재 방향을 result 배열에서 받아오기
			switch(d) {
			case (0): // 상
				break;
			case (1): // 하
				break;
			case (2): // 좌
				for(int r = 0; r < N; r++) {
					int left = 0; // 맨 왼쪽 칸
					int right = left+1;
					int block = 0;
					
					while(left <= N-1) {
						while(left <= N-1 && board[r][left] == 0) left++;
						
						right = left + 1;
						while(right <= N-1 && board[r][right] == 0) right++; // 맨 왼쪽 칸에서부터 블록이 있는 칸을 탐색
						
						if(left <= N-1 && right <= N-1) {
							if(board[r][left] == board[r][right]) { // 둘이 같은 블록이면
								board[r][left] += board[r][right]; // 왼쪽 칸과 오른쪽 칸을 합친 뒤
								board[r][right] = 0;
							}
						}
						
						if(left <= N-1 && right <= N-1) {
							board[r][block] = board[r][left];
							board[r][block+1] = board[r][right];	
							board[r][right] = board[r][right+1];
						} else if (left <= N-1) {
							board[r][block] = board[r][left];
							board[r][block+1] = 0;
						}
						
						for(int[] row : board) {
							System.out.println(Arrays.toString(row));
						}
						System.out.println();
						
						block = right;
						left = right+1;
						right = left+1;
					}
				}
				break;
			case (3): // 우
				for(int r = 0; r < N; r++) {
					int right = N-1; // 맨 오른쪽칸 
					int left = right-1;
					int block = N-1;
					
					while(right >= 0) {
						while(right >= 0 && board[r][right] == 0) right--; // 맨 오른쪽 칸에서부터 블록이 있는 칸을 탐색
						
						left = right-1;
						while(left >= 0 && board[r][left] == 0) left--;
						
						if(left >= 0 && right >= 0) {
							if(board[r][left] == board[r][right]) { // 둘이 같은 블록이면
								board[r][right] += board[r][left]; // 왼쪽 칸과 오른쪽 칸을 합친 뒤
								board[r][left] = 0;
							}
						}
						
						if(left >= 0 && right >= 0) {
							board[r][block] = board[r][right];
							board[r][block-1] = board[r][left];	
							board[r][left] = 0;
						} else if (right >= 0) {
							board[r][block] = board[r][right];
							board[r][block-1] = 0;
						}
						
						for(int[] row : board) {
							System.out.println(Arrays.toString(row));
						}
						System.out.println();
						
						block = left;
						right = left-1;
						left = right-1;
					}
				}
				break;
			}
			
		}
		
	}
	
} // end of class
