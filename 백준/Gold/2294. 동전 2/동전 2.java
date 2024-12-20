import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[] coins;
    static int[] dp;

    static final int MAX = Integer.MAX_VALUE-1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 동전의 종류, (1 ≤ n ≤ 100)
        K = Integer.parseInt(st.nextToken()); // 최종 가치의 합, (1 ≤ k ≤ 10,000)

        dp = new int[K+1];

        coins = new int[N];
        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for(int coin : coins) {
            for(int curr = coin; curr <= K; curr++) {
                dp[curr] = Math.min(dp[curr], dp[curr-coin]+1);
            }
        }

        System.out.println(dp[K] == MAX ? -1 : dp[K]);

    } // end of main
} // end of class