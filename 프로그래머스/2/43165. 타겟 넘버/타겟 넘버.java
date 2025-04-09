import java.util.*;

class Solution {
    static int N;
    static int answer;
    
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        
        dfs(numbers, 0, 0, target);

        return answer;
    }
    
    public static void dfs(int[] numbers, int idx, int curr, int target) {
        if(idx >= N) {
            if(curr == target) {
                answer++;
            }
            
            return;
        }
        
        dfs(numbers, idx+1, curr+numbers[idx], target);
        dfs(numbers, idx+1, curr-numbers[idx], target);
        
    }
}