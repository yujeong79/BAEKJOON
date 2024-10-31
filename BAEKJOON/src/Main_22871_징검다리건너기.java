import java.io.*;
import java.util.*;

/**
 * 가장 왼쪽에 있는 돌에서 출발하여 가장 오른족에 있는 돌로 건너가려고 한다.
 * i번째 돌에서 j(i < j)번째 돌로 이동할 때 (j - i)*(1 + |Ai - Aj|)만큼 힘을 쓴다.
 * 돌을 한 번 건너갈 때마다 쓸 수 있는 힘은 최대 K이다.
 * 
 * 가장 왼쪽 돌에서 출발하여 가장 오른쪽에 있는 돌로 건너갈 수 있는 모든 경우 중 K의 최솟값을 구해보자.
 */

public class Main_22871_징검다리건너기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] stones, dp;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			stones[i] = Integer.parseInt(st.nextToken());
		}
		
		// 최솟값이랑 최댓값을 뭐로 할까......................... 뭐로 할까욧!
		// 그런데 DP로 푸는게 더 쉬울거 같은데??????
		dp = new int[N];
		dp[0] = 0;
		
		for(int i = 1; i < N; i++) {
			dp[i] = Math.abs(stones[i-1] - stones[i]) + 1; 
			for(int j = 0; j < i; j++) {
				dp[i] = Math.min((j-i) * (Math.abs(stones[i-1] - stones[i]) + 1), dp[i]);
			}
		}
		
		
		
	} // end of main
} // end of class
