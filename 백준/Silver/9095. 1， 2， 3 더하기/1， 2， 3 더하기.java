import java.io.*;
import java.util.*;

/**
*    정수 n이 주어졌을 때 n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하라.
*    첫째 줄에 테스트 케이스의 개수 T가 주어진다.
*    n은 양수이며 11보다 작다.
**/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); 
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[N+1];
            dp[1] = 1;
            if(N >= 2) dp[2] = 2;
            if(N >= 3) dp[3] = 4;
            
            if(N < 4) {
                sb.append(dp[N]).append("\n");
                continue;
            }
            
            for(int i = 4; i <= N; i++) {
                dp[i] += dp[i-1] + dp[i-2] + dp[i-3];
            }
            
            sb.append(dp[N]).append("\n");

        } // end of test case
        
        System.out.println(sb);
    }
}