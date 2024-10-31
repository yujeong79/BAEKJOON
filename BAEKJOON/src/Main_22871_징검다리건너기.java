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
		
		stones = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			stones[i] = Integer.parseInt(st.nextToken());
		}
		
		// 최솟값이랑 최댓값을 뭐로 할까......................... 뭐로 할까욧!
		// 그런데 DP로 푸는게 더 쉬울거 같은데?????? DP로 최솟값과 최댓값을 구하고 이분탐색을 해야하나?
		dp = new int[N];
		dp[0] = 0;
		
		for(int j = 1; j < N; j++) {
			dp[j] = Math.abs(stones[j-1] - stones[j]) + 1; // 이전 칸에서 다음 칸으로 이동할 때 쓰는 힘 
			for(int i = 0; i < j; i++) {
				int result = (j-i) * (Math.abs(stones[i] - stones[j]) + 1);
				dp[j] = Math.min(result, dp[j]);
			}
		}
		
		System.out.println(Arrays.toString(dp));
		
		
		
	} // end of main
} // end of class
