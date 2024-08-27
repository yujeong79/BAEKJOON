import java.io.*;
import java.util.*;

public class 파이프옮기기1 {	
	static int N;
	static int[][] house; // 집
	
	static int[][] pipe = {{0, 0}, {0, 1}}; // 처음 위치
	static String[][] direction; // 현재 위치에서 어느 방향으로 이동했는지 체크하기 위한 배열?
	
	static int count = 0; // (N, N)으로 이동시키는 방법의 수
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		house = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String row = br.readLine();
			for(int j = 0; j < N; j++) {
				house[i][j] = row.charAt(j*2)-'0';
			}
		}
		
		Move();
		
		System.out.println(count);
		
	} // end of main
	
	// 현 파이프의 상태를 알려주는 메소드
	static int stateOfPipe() {
		if(pipe[0][0] == pipe[1][0]) return 0; // 현 상태 : 가로
		if(pipe[0][1] == pipe[1][1]) return 1; // 현 상태 : 세로
		else return 2; // 현 상태 : 대각선
	}
	
	// 파이프를 이동하는 메소드
	static void Move() {
		if(pipe[1][0] >= N-1 && pipe[1][1] >= N-1) { // (N, N)으로 이동했으면
			count++; // 방법의 수 증가
			return;
		}
		
		switch(stateOfPipe()) { // 현재 파이프의 상태
		case(0): // 가로인 경우
			if(!rowDirection()) diagonalDirection(); // 가로로 이동하지 못하면 대각선으로 이동
			break;
		case(1): // 세로인 경우
			if(!columnDirection()) diagonalDirection(); // 세로로 이동하지 못하면 대각선으로 이동
			break;
		case(2): // 대각선인 경우
			if(!rowDirection()) { // 가로로 이동하지 못하고
				if(!columnDirection()) diagonalDirection(); // 세로로 이동하지 못하면 대각선으로 이동
			}
			break;
		}
		
		Move();
	}
	
	// 가로 방향으로 이동하는 메소드
	static boolean rowDirection() {
		int c = pipe[1][0]; // 파이프 끝 점의 열
		int r = pipe[1][1]; // 파이프 끝 점의 행
		
		if(r+1 >= N-1) { // 파이프가 가로로 이동할 때 배열의 범위를 벗어나면
			return false;
		}
		
		if(stateOfPipe() == 0) { // 파이프가 가로 상태인 경우
			if(house[c][r+1] != 0) return false; //	가로로 이동할 때 벽을 만나면 이동 실패
			pipe[0][1]++; pipe[1][1]++; // 아니면 가로 이동
		} else { // 대각선인 경우 
			//if(house[c][r+1] != 0 || house[c+1][r] != 0 || house[c+1][r+1] != 0) return false;
			pipe[0][0]++;
			pipe[0][1]++; pipe[1][1]++;
		}
		
		System.out.println(Arrays.deepToString(pipe));
		return true;
	}
	
	// 세로 방향으로 이동하는 메소드
	static boolean columnDirection() {
		int c = pipe[1][0]; // 파이프 끝 점의 열
		int r = pipe[1][1]; // 파이프 끝 점의 행
		
		if(c+1 >= N-1) // 파이프가 세로로 이동할 때 배열의 범위를 벗어나면
			return false;
		
		if(stateOfPipe() == 1) { // 파이프가 세로 상태인 경우
			if(house[c+1][r] != 0) return false; // 세로로 이동할 때 벽을 만나면 이동 실패
			pipe[0][0]++; pipe[1][0]++;
		} else {
			//if(house[c][r+1] != 0 || house[c+1][r] != 0 || house[c+1][r+1] != 0) return false;
			pipe[0][1]++;
			pipe[0][0]++; pipe[1][0]++;
		}
		
		System.out.println(Arrays.deepToString(pipe));
		return true;
	}
	
	// 대각선 방향으로 이동하는 메소드
	static boolean diagonalDirection() {
		int c = pipe[1][0];
		int r = pipe[1][1];
		
		//if(house[c][r+1] != 0 || house[c+1][r] != 0 || house[c+1][r+1] != 0) return false;
		
		if(stateOfPipe() == 0) { // 파이프가 가로였을 경우
			pipe[0][1]++; pipe[1][1]++;
			pipe[1][0]++;
		} else if(stateOfPipe() == 1) { // 파이프가 세로였을 경우
			pipe[0][0]++; pipe[1][0]++;
			pipe[1][1]++;
		} else { // 파이프가 대각선이었을 경우
			pipe[0][0]++; pipe[0][1]++;
			pipe[1][0]++; pipe[1][1]++;
		}
		
		System.out.println(Arrays.deepToString(pipe));
		return true;
	}
	
} // end of class
