import java.util.*;

class Solution {
    int answer;
    boolean[][][] dp;
    
    public int solution(int[][] info, int n, int m) {
        answer = n + 1;
        dp = new boolean[info.length][n+1][m+1];
        dfs(info, 0, 0, 0, n, m);
        
        return answer > n ? -1 : answer;
    }
    
    public void dfs(int[][] info, int idx, int a, int b, int n, int m) {
        if(a >= n || b >= m) return;
        
        if(idx >= info.length) {
            answer = Math.min(answer, a);
            return;
        }
        
        if(dp[idx][a][b]) return;
        dp[idx][a][b] = true;
        
        dfs(info, idx+1, a + info[idx][0], b, n, m);
        dfs(info, idx+1, a, b + info[idx][1], n, m);
    }
}