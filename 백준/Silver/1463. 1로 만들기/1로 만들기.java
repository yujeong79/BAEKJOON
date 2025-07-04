import java.io.*;
import java.util.*;

/**
*    X가 3으로 나누어 떨어지면 3으로 나눈다
*    X가 2로 나누어 떨어지면 2로 나눈다
*    1을 뺀다
*    위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
*    연산을 사용하는 횟수의 최솟값을 출력하라.
**/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1 <= N <= 1_000_000
        int[] dp = new int[N+1];
        Arrays.fill(dp, N);
        dp[N] = 0;
        
        for(int i = N; i >= 1; i--) {
            if(i % 3 == 0) dp[i/3] = Math.min(dp[i/3], dp[i]+1);
            if(i % 2 == 0) dp[i/2] = Math.min(dp[i/2], dp[i]+1);
            dp[i-1] = Math.min(dp[i-1], dp[i]+1);
        }
        
        System.out.println(dp[1]);
    }
}