import java.util.*;

/*
    1 ≤ k ≤ tangerine의 길이 ≤ 100,000
    1 ≤ tangerine의 원소 ≤ 10,000,000
*/

class Solution {    
    public int solution(int k, int[] tangerine) {
        int tSize = tangerine.length;
        int[] tangerines = new int[10_000_001];
        
        for(int t : tangerine) {
            tangerines[t]++;
        }
        
        Arrays.sort(tangerines);
        
        int answer = 0;
        int cnt = 0;
        for(int i = 10_000_000; i >= 0; i--) {
            answer++;
            cnt += tangerines[i];
            
            if(cnt >= k) {
                break;
            }
        }
        
        return answer;
    }
}