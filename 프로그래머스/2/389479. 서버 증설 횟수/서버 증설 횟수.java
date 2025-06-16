import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        Queue<Integer> queue = new LinkedList<>();
        
        int answer = 0;
        for(int i = 0; i < 24; i++) {
            if(players[i]/m > queue.size()) {
                int requiredServers = players[i]/m - queue.size();
                answer += requiredServers;
                
                for(int j = 0; j < requiredServers; j++) {
                    queue.add(i+k-1);
                }
            }
            
            while(!queue.isEmpty() && i == queue.peek()) {
                queue.poll();
            }
        }
        
        return answer;
    }
}