import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // (1 ≤ N ≤ 1,000)

        int[] Arr = new int[N]; // (1 ≤ Ai ≤ 1,000)
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 1;
        int[] dp = new int[N];
        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(Arr[j] < Arr[i]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}