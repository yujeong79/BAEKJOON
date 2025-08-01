import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int size = queue1.length;
        int[] queue = new int[size*2];
        
        long sum1 = 0L;
        long sum2 = 0L;
        for(int i = 0; i < size*2; i++) {
            if(i >= size) {
                queue[i] = queue2[i-size];
                sum2 += queue2[i-size];
            }
            else {
                queue[i] = queue1[i];
                sum1 += queue1[i];
            }
        }
        
        if((sum1+sum2)%2 == 1) return -1;
        long half = (sum1+sum2)/2;
        
        int s = 0;
        int e = size;
        int cnt = 0;
        while(s <= e && e < size*2) {
            if(sum1 == half) return cnt;
            
            if(sum1 > half) { // 합이 목표값보다 큰 경우                
                sum1 -= queue[s++];
                cnt++;
            } else { // 합이 목표값보다 작은 경우
                sum1 += queue[e++];
                cnt++;
            }
        }
        
        return -1;
    }
}