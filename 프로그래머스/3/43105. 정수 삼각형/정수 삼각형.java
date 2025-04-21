/**
* 거쳐간 숫자의 최댓값을 return
* 부모의 입장에서 내려가면서 그리자
**/
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        
        int[][] dp = new int[size][size];
        dp[0][0] = triangle[0][0];
        
        for(int i = 0; i < size-1; i++) {
            for(int j = 0; j < i+1; j++) {
                dp[i+1][j] = Math.max(dp[i][j] + triangle[i+1][j], dp[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i][j] + triangle[i+1][j+1], dp[i+1][j+1]);
            }
        }
        
        int answer = 0;
        for(int n : dp[size-1]){
            answer = Math.max(answer, n);
        }
        
        return answer;
    }
}