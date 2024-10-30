import java.io.*;
import java.util.*;

public class Main_2565_전깃줄 {
	static class Line {
		int lineNumber;
		int A;
		int B;

		public Line(int a, int b) {
			A = a;
			B = b;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, maxCnt;
	static Line[] orderByA, orderByB;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 두 전봇대 사이의 전깃줄의 개수
		
		orderByA = new Line[N];
		orderByB = new Line[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			orderByA[i] = new Line(a, b);
		}
		
		// A를 기준으로 배열을 오름차순으로 정렬
		Arrays.sort(orderByA, new Comparator<Line>() {
			@Override
			public int compare(Line o1, Line o2) {
				return o1.A - o2.A;
			}
		});
		
		// A를 기준으로 정렬한 배열의 lineNumber를 순서대로 매기기
		for(int i = 0; i < N; i++) {
			orderByA[i].lineNumber = i+1;
		}
		
		orderByB = orderByA.clone();
		
		// B를 기준으로 배열을 오름차순으로 정렬
		Arrays.sort(orderByB, new Comparator<Line>() {
			@Override
			public int compare(Line o1, Line o2) {
				return o1.B - o2.B;
			}
		});
		
		maxCnt = 0;
		dp = new int[N];
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(orderByB[j].lineNumber < orderByB[i].lineNumber) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
			maxCnt = Math.max(dp[i], maxCnt);
		}
		
		System.out.println(N - maxCnt);
		
	} // end of main
} // end of class
