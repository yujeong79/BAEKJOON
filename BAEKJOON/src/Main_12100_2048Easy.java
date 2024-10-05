import java.io.*;
import java.util.*;

/**
 * perm 메서드 : 중복이 가능한 순열을 사용해서 가능한 방향의 조합을 정한 뒤 
 * play 메서드 : 블록들을 옮기자!
 * 
 * 처음에는 해당 방향에서부터 블록들을 합치면서 바로 옮기려고 했으나 너무 헷갈려서..
 * 일단 합칠 수 있는 블록들은 다 합치고 나중에 한 번에 해당 방향으로 옮기자로 변경
 * 
 * 놓친 반례
 * 다섯 번의 턴을 모두 진행한 뒤에도 한 번도 블록이 합쳐지지 않는 경우를 생각하지 못했다.	
 */

public class Main_12100_2048Easy {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, maxBlock;
	static int[][] board;
	
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); //  (1 ≤ N ≤ 20)
		board = new int[N][N];
		
		maxBlock = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				maxBlock = Math.max(maxBlock, board[i][j]);
			}
		}
		
		result = new int[5]; // 방향 조합을 저장할 배열
		perm(0);
		
		System.out.println(maxBlock);
		
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
		// 해당 방향 조합에서만 사용할 임시 2차원 배열 생성
		int[][] temp = new int[N][N];
		for(int i = 0; i < N; i++) {
			temp[i] = board[i].clone();
		}
		
		for(int d = 0; d < 5; d++) {
			int direction = result[d]; // 현재 방향을 result 배열에서 받아오기
			
			switch(direction) {
			case (0): // 상
				for(int i = 0; i < N; i++) { // 모든 열을 순회하면서
					int t = 0;
					int b = t+1;
					
					// 일단 합칠 수 있는 블럭은 모두 합치자
					while(t <= N-1 && b <= N-1) { 
						while(t <= N-1 && temp[t][i] == 0) t++; // 맨 위에서부터 탐색하면서 블록을 찾을 때까지 탐색
						
						b = t+1;
						while(b <= N-1 && temp[b][i] == 0) b++; // top의 아래칸부터 블록을 찾을 때까지 탐색
						
						if(t <= N-1 && b <= N-1) {
							if(temp[t][i] == temp[b][i]) { // 두 블록이 같다면, 합칠 수 있다면
								temp[t][i] += temp[b][i];
								temp[b][i] = 0;
								
								maxBlock = Math.max(maxBlock, temp[t][i]);
								
								t = b+1; // bottom의 다음부터 탐색하기 위해 값 갱신
								b = t+1; 
							} else { // 두 블록을 합칠 수 없다면
								t = b; // bottom 칸부터 다시 탐색
								b = t+1;
							}
						}
					}
					
					// 합칠 수 있는 모든 블럭을 합친 뒤 임시 배열을 사용해서 상 방향으로 전부 밀어버리기
					int[] tempColumn = new int[N];
					int tIdx = 0;
					for(int j = 0; j < N; j++) {
						if(temp[j][i] != 0) {
							tempColumn[tIdx++] = temp[j][i];
						}
					}
					
					for(int j = 0; j < N; j++) {
						temp[j][i] = tempColumn[j];
					}
				}
			
				break;
			case (1): // 하
				for(int i = 0; i < N; i++) { // 모든 열을 순회하면서
					int b = N-1;
					int t = b-1;
					
					// 일단 합칠 수 있는 블럭은 모두 합치자
					while(b >= 0 && t >= 0) { 
						while(b >= 0 && temp[b][i] == 0) b--; // 맨 바닥에서부터 탐색하면서 블록을 찾을 때까지 탐색
						
						t = b-1;
						while(t >= 0 && temp[t][i] == 0) t--; // bottom의 윗칸부터 블록을 찾을 때까지 탐색
						
						if(t >= 0 && b >= 0) {
							if(temp[t][i] == temp[b][i]) { // 두 블록이 같다면, 합칠 수 있다면
								temp[b][i] += temp[t][i];
								temp[t][i] = 0;
								
								maxBlock = Math.max(maxBlock, temp[b][i]);
								
								b = t-1; // top의 다음 칸부터 탐색
								t = b-1; 
							} else { // 두 블록을 합칠 수 없다면
								b = t; // top부터 다시 탐색
								t = b-1;
							}
						}
					}
					
					// 합칠 수 있는 모든 블럭을 합친 뒤 임시 배열을 사용해서 하 방향으로 전부 밀어버리기
					int[] tempColumn = new int[N];
					int tIdx = N-1;
					for(int j = N-1; j >= 0; j--) {
						if(temp[j][i] != 0) {
							tempColumn[tIdx--] = temp[j][i];
						}
					}
					
					for(int j = 0; j < N; j++) {
						temp[j][i] = tempColumn[j];
					}	
				}
			
				break;
				
			case (2): // 좌
				for(int i = 0; i < N; i++) { // 모든 행을 순회하면서
					int l = 0;
					int r = l+1;
					
					// 일단 합칠 수 있는 블럭은 모두 합치자
					while(r <= N-1 && l <= N-1) { 
						while(l <= N-1 && temp[i][l] == 0) l++; // 맨 왼쪽에서부터 탐색하면서 블록을 찾을 때까지 탐색
						
						r = l+1;
						while(r <= N-1 && temp[i][r] == 0) r++; // left의 오른쪽칸부터 블록을 찾을 때까지 탐색
						
						if(l <= N-1 && r <= N-1) {
							if(temp[i][l] == temp[i][r]) { // 두 블록이 같다면, 합칠 수 있다면
								temp[i][l] += temp[i][r];
								temp[i][r] = 0;
								
								maxBlock = Math.max(maxBlock, temp[i][l]);
								
								l = r+1; // right의 다음 칸부터 탐색하기 위해 값 갱신
								r = l+1; 
							} else { // 두 블록을 합칠 수 없다면
								l = r; // right 칸부터 다시 탐색
								r = l+1;
							}
						}
					}
					
					// 합칠 수 있는 모든 블럭을 합친 뒤 임시 배열을 사용해서 좌 방향으로 전부 밀어버리기
					int[] tempRow = new int[N];
					int tIdx = 0;
					for(int j = 0; j < N; j++) {
						if(temp[i][j] != 0) {
							tempRow[tIdx++] = temp[i][j];
						}
					}
					temp[i] = tempRow.clone();	
				}

				break;
			
			case (3): // 우 방향
				for(int i = 0; i < N; i++) { // 모든 행을 순회하면서
					int r = N-1;
					int l = r-1;
					
					// 일단 합칠 수 있는 블럭은 모두 합치자
					while(r >= 0 && l >= 0) { 
						while(r >= 0 && temp[i][r] == 0) r--; // 맨 오른쪽에서부터 탐색하면서 블록을 찾을 때까지 탐색
						
						l = r-1;
						while(l >= 0 && temp[i][l] == 0) l--; // right의 왼쪽칸부터 블록을 찾을 때까지 탐색
						
						if(l >= 0 && r >= 0) {
							if(temp[i][l] == temp[i][r]) { // 두 블록이 같다면, 합칠 수 있다면
								temp[i][r] += temp[i][l];
								temp[i][l] = 0;
								
								maxBlock = Math.max(maxBlock, temp[i][r]); // maxBlock 갱신
								
								r = l-1; // left의 다음 칸부터 탐색하기 위해 값 갱신
								l = r-1; 
							} else { // 두 블록을 합칠 수 없다면
								r = l; // left 칸부터 다시 탐색
								l = r-1;
							}
						}
					}
					
					// 합칠 수 있는 모든 블럭을 합친 뒤 임시 배열을 사용해서 우 방향으로 전부 밀어버리기
					int[] tempRow = new int[N];
					int tIdx = N-1;
					for(int j = N-1; j >= 0; j--) {
						if(temp[i][j] != 0) {
							tempRow[tIdx--] = temp[i][j];
						}
					}
					temp[i] = tempRow.clone();	
				}
			
				break;
				
			} // switch 종료
		}	
	}
	
} // end of class
