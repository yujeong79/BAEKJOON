import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] isPuddle = new boolean[n+1][m+1];
        for(int[] puddle : puddles) {
            isPuddle[puddle[1]][puddle[0]] = true;
        }
        
        long[][] dp = new long[n+1][m+1];
        dp[1][1] = 1;
        
        int div = 1_000_000_007;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(i == 1 && j == 1) {
                    continue;
                } 
                
                if(isPuddle[i][j]) {
                    dp[i][j] = 0;  
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % div;
                }
            }
        }

        return (int) dp[n][m];
    }
}