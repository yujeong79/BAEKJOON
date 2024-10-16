import java.io.*;
import java.util.*;

public class Main_2579_계단오르기 {	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] stairs, dp;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 계단의 수
		
		dp = new int[N+1];
		
		stairs = new int[N+1];
		for(int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = stairs[1];
		
		if(N >= 2) dp[2] = stairs[1] + stairs[2];
	
		for(int i = 3; i <= N; i++) { // 해당 계단은 무조건 밟는다고 생각하는거야
			// i-2에서 두 계단을 건너는 경우와 i-3에서 두 계단을 건너서 i-1과 i를 건너는 경우 중 큰 것을 저장
			dp[i] = Math.max(dp[i-2], dp[i-3]+stairs[i-1]) + stairs[i];
		}
		
		System.out.println(dp[N]);
		
	} // end of main
} // end of class
