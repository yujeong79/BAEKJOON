import java.io.*;
import java.util.*;

/**
<<<<<<< HEAD
 * 시작점하고 끝점을 모두 받아보자
=======
 * N*N의 map을 만들고 파이프가 있으면 1, 없으면 0이다.
 * isPromising
 * 	가로인 경우(0) : 파이프를 옮겼을 때 벽에 부딪히지 않거나 끝에 닿지 않으면 true
 * 		가로 먼저 해보고 다 갔다가 다시 백해서 돌아올 때 대각선 해보기?
 * 	세로인 경우(1) : 파이프를 옮겼을 때 벽에 부딪히지 않거나 끝에 닿지 않으면 true
 * 		세로 먼저 해보고 다 갔다가 다시 백해서 돌아올 때 대각선 해보기?
 *  대각선인 경우(2) :  파이프를 옮겼을 때 벽에 부딪히지 않으면 true
 * 		가로 먼저 해보고 다 갔다가 다시 백해서 돌아올 때 세로 해보고 대각선 해보기?
>>>>>>> branch 'main' of https://github.com/yujeong79/BAEKJOON.git
 */

public class Main_BAEKJOON_17070_파이프옮기기1_Gold5 {	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int N;
	private static int[][] map;

<<<<<<< HEAD
	private static int answer;
=======
	private static char[][] map;

	private static int cnt;

	private static int r = 0; // 현재 파이프의 시작점
	private static int c = 0;
	
>>>>>>> branch 'main' of https://github.com/yujeong79/BAEKJOON.git
	
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
		
<<<<<<< HEAD
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
=======
		Move(0, 0); // 시작 위치
		
//		for(char[] r : map) {
//			System.out.println(Arrays.toString(r));
//		}
>>>>>>> branch 'main' of https://github.com/yujeong79/BAEKJOON.git
		
<<<<<<< HEAD
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
	
=======
	} // end of main


	private static void Move(int i, int j) {
		if(i == N-1 && j == N-1) {
			cnt++;
			return;
		}
		
		switch(pipeDirection()) {
		case(0): // 가로인 경우
			if(isPromising(0)) { // 오른쪽으로 한 칸 이동이 가능하다면
				map[r][c] = '0';
				map[r][c+2] = '-';
				c++; // 오른쪽으로 한 칸 이동
			}
			
		case(1): // 세로인 경우
			isPromising(1);
		case(2): // 대각선인 경우
			isPromising(2);
		}
		
	}
	
	/**
	 * 파이프의 특정 방향으로의 이동이 유망한지 반환
	 * @param d : 방향, 0은 가로 1은 세로 2는 대각선
	 * @return
	 */
	private static boolean isPromising(int d) {
		
		return true;
	}
	
	/**
	 * 파이프의 방향을 반환하는 메소드
	 */
	private static int pipeDirection() {
		if(map[r+1][c] == '-') return 0; // 가로
		else if (map[r][c+1] == '-') return 1; // 세로
		else return 2;
	}
>>>>>>> branch 'main' of https://github.com/yujeong79/BAEKJOON.git
} // end of class
