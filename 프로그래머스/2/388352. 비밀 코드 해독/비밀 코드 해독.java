import java.util.*;

class Solution {
    int answer;
    int[] result;
    boolean[] isSelected;
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        result = new int[5];
        comb(n, q, ans, 0, 1);
       
        return answer;
    }
    
    public void comb(int n, int[][] q, int[] ans, int cnt, int num) {     
        if(cnt == 5) {
            if(isPossible(q, ans)) answer++;
            return;
        }
        
        for(int i = num; i <= n; i++) {
            result[cnt] = i;
            comb(n, q, ans, cnt+1, i+1);
        }
    }
    
    public boolean isPossible(int[][] q, int[] ans) {
        for(int i = 0; i < q.length; i++) {
            int cnt = 0;
            for(int n : q[i]) {
                for(int r : result) {
                    if(r == n) cnt++;
                }
            }
            
            if(cnt != ans[i]) return false;
        }
        
        return true;
    }
}