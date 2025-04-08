import java.util.*;

/**
* 2 <= scoville.length <= 1,000,000 
* 0 <= scoville <= 1,000,000
* 0 <= K <= 1,000,000,000
**/

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville) {
            pq.add(s);
        }
        
        int answer = 0;
        
        while(pq.peek() < K) {
            if(pq.size() < 2) return -1;
            
            int first = pq.poll();
            int second = pq.poll();
            
            pq.add(first + second*2);
            answer++;
        }
        
        return answer;
    }
}