/**
* params n : 입국심사를 기다리는 사람 수, 1명 이상 10억명 이하
* params times[i] : 각 심사관이 한 명을 심사하는데 걸리는 시간, 1분 이상 10억분 이하
* params times.length : 심사관, 1명 이상 100,000명 이하
**/
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = binarySearch(n, times);
        return answer;
    }
    
    public long binarySearch(int n, int[] times) {
        long start = 1;
        long end = Arrays.stream(times).max().getAsInt
            () * (long) n;
        
        long answer = end;
        while(start <= end) {
            long mid = (start + end) / 2;
            
            if(isPossible(mid, n, times)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
    
    public boolean isPossible(long mid, int n, int[] times) {
        long total = 0;
        
        for(int t : times) {
            total += mid / t;
            if(total >= n) return true;
        }
        
        return false;
    }
}