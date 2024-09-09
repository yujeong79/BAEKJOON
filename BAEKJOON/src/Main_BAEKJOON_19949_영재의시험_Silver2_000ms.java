import java.io.*;
import java.util.*;

public class Main_BAEKJOON_19949_영재의시험_Silver2_000ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int[] answer;
	static int N = 10;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 10; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}
		
		backTracking(0);
		
	} // end of main

	private static void backTracking(int num) {
		if(num == N) { // 모든 문제의 정답을 썼으면
			return;
		}
		
		for(int i = 1; i <= 5; i++) {
			
		}
		
	}
	
} // end of class
