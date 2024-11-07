import java.io.*;
import java.util.*;

public class Main_3190_뱀 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, K, L;
	static boolean[][] board;
	static Queue<int[]> dirInfo;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 보드의 크기
		K = Integer.parseInt(br.readLine()); // 사과의 개수
		
		board = new boolean[N][N];
		
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board[r-1][c-1] = true; // 사과의 위치
		}
		
		dirInfo = new LinkedList<>();
		L = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수
		for(int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int T = Integer.parseInt(st.nextToken());
			String D = st.nextToken();
			if(D.equals("D")) dirInfo.add(new int[] {T, 1}); // 오른쪽으로 90도 회전
			else dirInfo.add(new int[] {T, -1}); // 왼쪽으로 90도 회전
		}
		
	} // end of main
	
	// 상 우 하 좌
	static final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
} // end of class
