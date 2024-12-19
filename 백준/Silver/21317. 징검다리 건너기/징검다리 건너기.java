import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[][] stones;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 돌의 수

        dp = new int[Math.max(4, N+1)][2];
        stones = new int[Math.max(4, N)][2];
        for(int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int lower = Integer.parseInt(st.nextToken());
            int higher = Integer.parseInt(st.nextToken());
            stones[i] = new int[] {lower, higher};
        }

        K = Integer.parseInt(br.readLine());

        dp[2][1] = dp[3][1] = 10000;
        dp[2][0] = stones[1][0];
        dp[3][0] = Math.min(dp[2][0] + stones[2][0], dp[1][0] + stones[1][1]);

        for(int i = 4; i <= N; i++) {
            dp[i][0] = Math.min(dp[i-1][0] + stones[i-1][0], dp[i-2][0] + stones[i-2][1]);
            dp[i][1] = Math.min(Math.min(dp[i-1][1] + stones[i-1][0], dp[i-2][1] + stones[i-2][1]), dp[i-3][0] + K);
        }

        System.out.println(Math.min(dp[N][0], dp[N][1]));

    } // end of main
} // end of class