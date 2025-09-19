import java.util.*;

/*
    갈수록 제곱의 차는 커진다.
    그러므로 최대한 큰 수를 없애는게 이득?
    -> 정말 반례가 없을까?
    -> 최대한 큰 수가 없게끔 해야하는듯
    
    1 <= works.length <= 20,000
    1 <= works[i] <= 50,000
    1 <= n <= 1,000,000
*/

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works) pq.add(w);
        
        while(n-- > 0 && !pq.isEmpty()) {
            int curr = pq.poll();
            if(curr > 0) {
                pq.add(--curr);
            }
        }
        
        long answer = 0;
        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}