import java.io.*;
import java.util.*;

public class Main_BAEKJOON_16926_배열돌리기1_Gold5 {
	
	// 하 우 상 좌
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int d = 0; // 방향
	
	static int N;
	static int M;
	static int[][] matrix;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // row
		M = Integer.parseInt(st.nextToken()); // column
		int R = Integer.parseInt(st.nextToken()); // 회전 수
		
		matrix = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(R-- > 0) {
			rotation();
		}
		
		for(int[] m : matrix) {
			for(int n : m) sb.append(n).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
		
	} // end of main
	
	static void rotation() {		
		
		int[][] tmp = new int[N][M];
		int rSize = N; int cSize = M;
		
		int start = 0; // 사각형의 시작점
		
		int cnt = N < M ? N/2 : M/2; // 사각형의 개수 구하기
		
		int rect = 0; // 점점 숫자가 커질수록 안쪽 사각형
		while(rect++ < cnt) { // N*M 크기의 매트릭스에서 회전해야하는 사각형의 수 N/2	
			d = 0;
			int r = start; int c = start++; // 현재 위치
			
			for(int i = 0; i < rSize-1; i++) { // N-1번만큼 하 방향 이동
				tmp[r+1][c] = matrix[r][c];
				r += dr[d]; 
				c += dc[d];
			}
			
			tmp[r][c+1] = matrix[r][c]; // 마지막칸 옮기고 방향 전환
			d = (d+1)%3;
			
			for(int i = 0; i < cSize-1; i++) { // M-1번만큼 우 방향 이동
				tmp[r][c+1] = matrix[r][c];
				r += dr[d]; c += dc[d];
			}
			
			tmp[r-1][c] = matrix[r][c]; // 마지막칸 옮기고 방향 전환
			d = (d+1)%3;
			
			for(int i = 0; i < rSize-1; i++) { // N-1번만큼 상 방향 이동
				tmp[r-1][c] = matrix[r][c];
				r += dr[d]; c += dc[d];
			}
			
			tmp[r][c-1] = matrix[r][c]; // 마지막칸 옮기고 방향 전환
			d = (d+1)%4;
			
			for(int i = 0; i < cSize-1; i++) { // M-1번만큼 좌 방향 이동
				tmp[r][c-1] = matrix[r][c];
				r += dr[d]; c += dc[d];
			}
			
			rSize -= 2; // 사각형의 크기 줄이기
			cSize -= 2;
		}
		matrix = tmp;
	}
	
} // end of class
