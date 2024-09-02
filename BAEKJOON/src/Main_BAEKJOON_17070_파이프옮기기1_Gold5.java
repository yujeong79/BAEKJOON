import java.io.*;
import java.util.*;

/**
 * 시작점하고 끝점을 모두 받아보자
 */

public class Main_BAEKJOON_17070_파이프옮기기1_Gold5 {	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int N;
	private static int[][] map;
	private static int[][] pipeDirection;
	
	private static int r;
	private static int c;
	private static int d; // 파이프의 방향 1 : 가로, 2 : 세로, 3 : 대각선 

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
		
		r = 0; c = 1; // 현재 파이프의 끝점
		d = 1;
		
		pipeDirection = new int[N][N];
		pipeDirection[r][c] = d;
		Move();
	}

	private static void Move() {
		if(r >= N-1 && c >= N-1) {
			answer++;
			return;
		}
		
//		switch(d) {
//		case(1):
//			if()
//		case(2):
//		case(3):
//		}
		
	}
	
} // end of class
