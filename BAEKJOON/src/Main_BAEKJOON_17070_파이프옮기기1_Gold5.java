import java.io.*;
import java.util.*;

/**
 * N*N의 map을 만들고 파이프가 있으면 1, 없으면 0이다.
 * isPromising
 * 	가로인 경우(0) : 파이프를 옮겼을 때 벽에 부딪히지 않거나 끝에 닿지 않으면 true
 * 		가로 먼저 해보고 다 갔다가 다시 백해서 돌아올 때 대각선 해보기?
 * 	세로인 경우(1) : 파이프를 옮겼을 때 벽에 부딪히지 않거나 끝에 닿지 않으면 true
 * 		세로 먼저 해보고 다 갔다가 다시 백해서 돌아올 때 대각선 해보기?
 *  대각선인 경우(2) :  파이프를 옮겼을 때 벽에 부딪히지 않으면 true
 * 		가로 먼저 해보고 다 갔다가 다시 백해서 돌아올 때 세로 해보고 대각선 해보기?
 */

public class Main_BAEKJOON_17070_파이프옮기기1_Gold5 {	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int N; // N*N 맵

	private static char[][] map;

	private static int cnt;

	private static int r = 0; // 현재 파이프의 시작점
	private static int c = 0;
	
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			String row = br.readLine();
			for(int j = 0, c = 0; j < N; j++, c+=2) {
				map[i][j] = row.charAt(c);
			}
		}
		
		map[0][0] = '-'; map[0][1] = '-';
		
		Move(0, 0); // 시작 위치
		
//		for(char[] r : map) {
//			System.out.println(Arrays.toString(r));
//		}
		
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
} // end of class
