import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int x = 1; x <= r2; x++) {
            long minY = (long)Math.ceil(Math.sqrt(1.0*r1*r1 - 1.0*x*x));
            long maxY = (long)Math.floor(Math.sqrt(1.0*r2*r2 - 1.0*x*x));
            
            answer += maxY - minY + 1;
        }
        
        return answer*4;
    }
}