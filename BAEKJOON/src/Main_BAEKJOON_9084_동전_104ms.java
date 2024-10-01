import java.io.*;
import java.util.StringTokenizer;

/**
 * coins = {1, 2, 5} 이고, 목표 금액이 10원인 경우
 * 
 * 1원으로 1원부터 10원까지 만들 수 있는 경우의 수를 dp에 저장
 * 2원으로 2원부터 10원까지 만들 수 있는 경우의 수를 dp에 저장
 * 5원으로 5원부터 10원까지 만들 수 있는 경우의 수를 dp에 저장
 * 
 * dp[0] = 1로 초기화 => 0원을 만드는 경우의 수는 아무 동전도 사용하지 않고 0원을 만드는 방법은 1가지이기 때문
 * 
 *    0  1  2  3  4  5  6  7  8  9  10
 * 1  1  1  1  1  1  1  1  1  1  1  1
 * 2        2  2  3  3  4  4  5  5  6
 * 5                 4  5  6  7  8  10
 * 
 * 기본적으로 coin만 사용해서 money를 만든다고 했을 때 경우의 수는 dp[currMoney - coin]의 값
 * 왜냐하면 coin 동전만 사용한다고 했을 때 currMoney에서 - coin을 뺀 값에서 그냥 coin을 더해주는 경우의 수 1가지 뿐이니까
 * 
 * - 2원을 사용해서 2원을 만드는 경우의 수는 이미 dp에 저장된 (1원을 사용해서 2원을 만드는 경우의 수) + (2원을 사용해서 2원을 만드는 경우의 수)를 더해준 값
 * - 2원을 사용해서 4원을 만드는 경우의 수는 이미 dp에 저장된 (1원을 사용해서 4원을 만드는 경우의 수) + (2원을 만드는 경우의 수)를 더해준 값이다.	
 */

public class Main_BAEKJOON_9084_동전_104ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[] cost;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine()); 
		int testCase = 0;
		while(++testCase <= T) {
			N = Integer.parseInt(br.readLine()); // 동전의 개수
			
			cost = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			M = Integer.parseInt(br.readLine()); // N가지 동전으로 만들어야 할 금액
			
			int[] dp = new int[M+1];
			dp[0] = 1;
			
			for(int c : cost) {
				for(int i = c; i <= M; i++) {
					dp[i] += dp[i-c];
				}
			}
			
			System.out.println(dp[M]);
		} // end of testCase
	} // end of main
} // end of class