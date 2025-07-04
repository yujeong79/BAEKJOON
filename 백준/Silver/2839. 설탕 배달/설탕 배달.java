import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 3 ≤ N ≤ 5000
        int INF = 10_000;
        
        // dp 초기화
        int[] dp = new int[N+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        dp[3] = 1;
            
        for(int i = 3; i <= N; i++) {
            if(dp[i-3] != INF) dp[i] = Math.min(dp[i], dp[i-3]+1);
            if(i >= 5 && dp[i-5] != INF) dp[i] = Math.min(dp[i], dp[i-5]+1);
        }
        
        System.out.println(dp[N] == INF ? -1 : dp[N]);
    }
}