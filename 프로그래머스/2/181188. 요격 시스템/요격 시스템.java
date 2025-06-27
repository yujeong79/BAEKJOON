import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
           if(o1[1] == o2[1])
               return o1[0] - o2[0];
            
            return o1[1] - o2[1];
        });
        
        int answer = 0;
        int curr = targets[0][1];
        answer++;
        for(int i = 1; i < targets.length; i++) {
            if(targets[i][0] >= curr) {
                curr = targets[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}