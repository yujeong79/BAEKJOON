/**
* params n : 입국심사를 기다리는 사람 수, 1명 이상 10억명 이하
* params times[i] : 각 심사관이 한 명을 심사하는데 걸리는 시간, 1분 이상 10억분 이하
* params times.length : 심사관, 1명 이상 100,000명 이하
**/
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        int tSize = times.length;
        
        long start = 1L;
        long end = 1_000_000_000L * 1_000_000_000L;
        
        long answer = 0;
        while(start <= end) {
            long mid = (start+end)/2;
            
            if(binarySearch(n, times, mid)) {
                end = mid-1;
                answer = mid;
            } else {
                start = mid+1;
            }    
        }

        return answer;
    }
    
    public static boolean binarySearch(int n, int[] times, long mid) {
        long sum = 0;
        
        for(int t : times) {
            sum += mid / t;    
            if(sum >= n) return true;
        }
    
        return false;
    }
}