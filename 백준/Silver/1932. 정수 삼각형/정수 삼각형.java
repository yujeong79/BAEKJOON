import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // (1 ≤ n ≤ 500)
        int[][] dp = new int[N+1][N+1];

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= i; j++) {
                int curr = Integer.parseInt(st.nextToken());

                dp[i][j] = Math.max(dp[i-1][j] + curr, dp[i-1][j-1] + curr);
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans);
    }
}