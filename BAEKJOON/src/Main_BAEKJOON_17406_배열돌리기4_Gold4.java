import java.io.*;
import java.util.*;

public class Main_BAEKJOON_17406_배열돌리기4_Gold4 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int N; // 전체 배열의 행
	private static int M; // 전체 배열의 열
	private static int K; // 회전 연산의 개수
	
	private static int[][] matrix;
	private static String[] command;
	
	private static String[] result;
	private static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // N*M
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // 회전 연산의 개수
		
		matrix = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < K; i++) {
			command[i] = br.readLine();
		}
		
		perm(0);
	}

	private static void perm(int cnt) { // 회전 연산의 순서를 바꿔주는 순열 메소드
		if(cnt == K) {
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
		for(String str : result) { // 회전 연산 하나를 받아서
			StringTokenizer st = new StringTokenizer(str, " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
		}
	}
}
