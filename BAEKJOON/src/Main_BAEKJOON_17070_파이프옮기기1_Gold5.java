import java.io.*;
import java.util.*;

/**
 * 시작점하고 끝점을 모두 받아보자
 */

public class Main_BAEKJOON_17070_파이프옮기기1_Gold5 {	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int N; // N*N 맵

	private static char[][] map;
	private static int[][] isVisited;
	
	private static int r1; // 현재 위치
	private static int c1;
	private static int r2;
	private static int c2;
	
	private static int answer;
	
	
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
		
		isVisited = new int[N][N];
		r1 = 0; c1 = 0; r2 = 0; c2 = 1;
		answer = 0;
		movePipe();
		
		System.out.println(answer);
	} // end of main


	private static void movePipe() {
		if(r2 >= N-1 && c2 >= N-1) { // 파이프가 (N,N)에 도착했으면 종료
			answer++;
			return;
		}
		
		for(char[] r : map) {
			System.out.println(Arrays.toString(r));
		}
		System.out.println(r1 + ", " + c1);
		System.out.println(r2 + ", " + c2);
		
		int d = pipeDirection();

		switch(d) { // 파이프 상태에 따라 이동
		case(1): // 파이프가 가로 방향인 경우
			if(isVisited[r1][c1] == 0) { // 한 번도 간 적이 없다면
				if(isPromising(1)) { // 가로 방향으로 이동할 수 있으면
					
					isVisited[r1][c1] = 1; // 가로 방향으로 이동했다고 체크
					
					map[r1][c1] = '0';
					c1++; c2++;
					map[r2][c2] = '-';
					
					movePipe(); // 이어서 이동
				}
				else System.out.println("가로 이동 실패");
			}
		
			if(!isPromising(1) || isVisited[r1][c1] == 1) { // 더이상 가로 방향으로 이동할 수 없거나 이전에 가로 방향으로 이동한 적이 있다면
				if(isPromising(3)) {
					isVisited[r1][c1] = 3;
					
					map[r1][c1] = '0';
					c1++; r2++; c2++;
					System.out.println(r2 + ", " + c2);
					map[r2][c2] = '-';
					
					movePipe();
				}
			}

		case(2): // 파이프가 세로 방향인 경우
			if(isVisited[r1][c1] == 0) { // 한 번도 간 적이 없다면
				if(isPromising(2)) { // 세로 방향으로 이동할 수 있으면
					isVisited[r1][c1] = 2; // 세로 방향으로 이동했다고 체크
					
					map[r1][c1] = '0';
					r1++; r2++;
					map[r2][c2] = '-';
					
					movePipe(); // 이어서 이동
				}
			}
		
			if(!isPromising(2) || isVisited[r1][c1] == 2) { // 이 전에 세로 방향으로 이동한 적이 있다면
				if(isPromising(3)) {
					isVisited[r1][c1] = 3;
					
					map[r1][c1] = '0';
					r1++; r2++; c2++;
					map[r2][c2] = '-';
					
					movePipe();
				}
			}
		case(3): // 파이프가 대각선 방향인 경우
			if(isVisited[r1][c1] == 0) { // 한 번도 간 적이 없다면
				if(isPromising(1)) { // 가로 방향으로 이동할 수 있으면
					isVisited[r1][c1] = 1; // 가로 방향으로 이동했다고 체크
					
					map[r1][c1] = '0';
					r1++; c1++; c2++;
					map[r2][c2] = '-';
					
					movePipe(); // 이어서 이동
				}
			}
		
			if(!isPromising(1) || isVisited[r1][c1] == 1) { // 가로 방향으로 갈 수 없거나 세로 방향으로 간 적이 없다면
				if(isPromising(2)) { // 세로 방향으로 이동할 수 있으면
					isVisited[r1][c1] = 2; // 세로 방향으로 이동했다고 체크
					
					map[r1][c1] = '0';
					r1++; c1++; r2++; 
					map[r2][c2] = '-';
					
					System.out.println("세로방향성공");
					movePipe(); // 이어서 이동
				}
				System.out.println("세로방향실패");
			}
		
			if(!isPromising(1) || !isPromising(2) ||  isVisited[r1][c1] == 1 || isVisited[r1][c1] == 2) { // 이 전에 세로 방향으로 이동한 적이 있다면
				if(isPromising(3)) {
					isVisited[r1][c1] = 3;
					
					map[r1][c1] = '0';
					r1++; c1++; r2++; c2++;
					map[r2][c2] = '-';
					
					movePipe();
				}
			}
		}
	}
	
	private static int pipeDirection() {
		if(map[r1][c1+1] == '-') return 1; // 파이프가 가로 방향인 경우
		else if(map[r1+1][c1] == '-') return 2; // 파이프가 세로 방향인 경우
		else return 3; // 파이프가 대각선 방향인 경우
	}
	
	private static boolean isPromising(int d) {
		switch(d) {
		case(1):
			if(c2 + 1 < N-1 && map[r2][c2 + 1] != 1) return true; 
			switch(pipeDirection()) {
			case(1):
				if(c2 + 1 == N-1 && r2 == N-1) return true;
			case(3):
				if(c2 + 1 == N-1 && r2 == N-1) return true;
			}
			break;
		case(2):
			if(r2 + 1 < N-1 && map[r2 + 1][c2] != 1) return true;
			switch(pipeDirection()) {
			case(2):
				System.out.println(c2 + ", " + (r2+1));
				if(c2 == N-1 && r2 + 1 == N-1) return true; break;
			case(3):
				if(c2 + 1 == N-1 && r2 == N-1) return true;
			}
			break;
		case(3):
			if(map[r2][c2 + 1] != 1 && map[r2+1][c2] != 1 && map[r2+1][c2+1] != 1) return true;
			switch(pipeDirection()) {
			case(2):
				if(c2 == N-1 && r2 + 1 == N-1) return true;
			case(3):
				if(c2 + 1 == N-1 && r2 == N-1) return true;
			}
			break;
		}
		return false;
	}
	
} // end of class
