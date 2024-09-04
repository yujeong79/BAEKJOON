import java.io.*;
import java.util.*;

public class Main_BAEKJOON_17406_배열돌리기4_Gold4 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	// 우 하 좌 상
	private static int[] dr = {0, 1, 0, -1};
	private static int[] dc = {1, 0, -1, 0};
	private static int d = 0; // 방향
	
	private static int N; // 전체 배열의 행
	private static int M; // 전체 배열의 열
	private static int K; // 회전 연산의 개수
	
	private static int[][] origin;
	private static int[][] matrix;
	private static String[] command;
	
	private static String[] result;
	private static boolean[] isSelected;
	
	private static int answer;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // N*M
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // 회전 연산의 개수
		
		origin = new int[N][M];
		matrix = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		command = new String[K];
		for(int i = 0; i < K; i++) {
			command[i] = br.readLine();
		}
		
		answer = Integer.MAX_VALUE;
		result = new String[K];
		isSelected = new boolean[K];
		perm(0);
		
		System.out.println(answer);
	}

	private static void perm(int cnt) { // 회전 연산의 순서를 바꿔주는 순열 메소드
		if(cnt == K) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					matrix[i][j] = origin[i][j];
				}
			}
			rotation();
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				result[cnt] = command[i];
				perm(cnt+1);
				isSelected[i] = false;
			}
		}
	}

	private static void rotation() { // 회전 연산을 서로 다른 순서로 수행하는 메소드
		int[][] temp = new int[N][M];
		
		for(String str : result) { // 회전 연산 하나를 받아서
			StringTokenizer st = new StringTokenizer(str, " ");
			int inputR = Integer.parseInt(st.nextToken());
			int inputC = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			int startRow = (inputR-1)-s; // 회전 연산을 수행 할 왼쪽 상 좌표
			int startColumn = (inputC-1)-s;
			
			int r = startRow; // 현재 좌표 
			int c = startColumn;
			
			int endRow = (inputR-1)+s; // 회전 연산을 수행 할 오른쪽 상 좌표
			int endColumn = (inputC-1)+s;
			
			int count = 0;
			int totalCount = (endColumn-startColumn+1)/2;
			while(count < totalCount) {
				if(r + dr[d] <= endRow && r + dr[d] >= startRow && c + dc[d] <= endColumn && c + dc[d] >= startColumn) {
					if(r+dr[d] == startRow && c+dc[d] == startColumn) { // 한 바퀴 회전을 끝냈으면
						temp[r+dr[d]][c+dc[d]] = matrix[r][c];
						r += dr[d] + 1; c += dc[d] + 1;
						startRow++; startColumn++;
						endRow--; endColumn--;
						count++;
					} else {
						temp[r+dr[d]][c+dc[d]] = matrix[r][c];
						r += dr[d];
						c += dc[d];
					}
				} else {
					d = (d+1)%4;
					temp[r+dr[d]][c+dc[d]] = matrix[r][c];
					r += dr[d];
					c += dc[d];
				}
			}
			
			for(int i = (inputR-1)-s; i <= (inputR-1)+s; i++) {
				for(int j = (inputC-1)-s; j <= (inputC-1)+s; j++) {
					if(temp[i][j] != 0) matrix[i][j] = temp[i][j];
				}
			}
			
			int arrValue = Integer.MAX_VALUE;
			// 회전 연산을 모두 수행
			for(int i = 0; i < N; i++) {
				int rowSum = 0;
				for(int j = 0; j < M; j++) {
					rowSum += matrix[i][j];
				}
				arrValue = Math.min(arrValue, rowSum);
			}
			
			answer = Math.min(answer, arrValue);
		}
	}
}
