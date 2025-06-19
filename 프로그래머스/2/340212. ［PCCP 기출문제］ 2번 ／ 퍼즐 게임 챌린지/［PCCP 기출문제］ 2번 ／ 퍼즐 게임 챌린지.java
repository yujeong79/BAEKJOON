/*
    1 ≤ 퍼즐의 수(n, diffs의 길이, times의 길이) ≤ 300,000
    1 ≤ 퍼즐의 난이도(diffs[i], 나의 숙련도) ≤ 100,000
    1 ≤ 퍼즐 소요 시간(times[i]) ≤ 10,000
    1 ≤ limit ≤ 10^15
*/
import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = binarySearch(diffs, times, limit);
        return answer;
    }
    
    public int binarySearch(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = 100_000;
        
        int answer = 0;
        while(start <= end) {
            int mid = (start+end)/2;
            
            if(isPossible(mid, diffs, times, limit)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
    
    public boolean isPossible(int level, int[] diffs, int[] times, long limit) {
        long total = 0L;
        
        for(int i = 0; i < diffs.length; i++) {
            if(diffs[i] <= level) {
                total += times[i];
            } else {
                total += (times[i] + times[i-1]) * (diffs[i] - level) + times[i];
            }
            
            if(total > limit) return false;
        }
        
        return true;
    }
}