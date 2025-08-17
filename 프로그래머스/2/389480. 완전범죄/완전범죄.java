import java.util.*;

class Solution {
    static int answer;
    static boolean[][][] memoization;
    static int[][] tInfo;
    
    public int solution(int[][] info, int n, int m) {
        tInfo = info;
        answer = n;
        
        memoization = new boolean[info.length][n][m];
        DFS(0, 0, 0, n, m);
        
        return answer >= n ? -1 : answer;
    }
    
    public static void DFS(int idx, int aSum, int bSum, int n, int m) {
        if(aSum >= n || bSum >= m) return;
        
        if(idx >= tInfo.length) {
            answer = Math.min(answer, aSum);
            return;
        }
        
        if(memoization[idx][aSum][bSum]) return;
        memoization[idx][aSum][bSum] = true;
        
        DFS(idx+1, aSum+tInfo[idx][0], bSum, n, m);
        DFS(idx+1, aSum, bSum+tInfo[idx][1], n, m);
    }
}