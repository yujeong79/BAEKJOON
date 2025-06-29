/*
    하나의 인덱스를 잡고(부분 수열의 마지막 인덱스) 
    이분 탐색으로 부분 수열의 시작 인덱스 찾기 
*/

import java.util.*;

class Solution {
    int[] dp;
    int length;
    int[] answer;
    
    public int[] solution(int[] sequence, int k) {
        dp = new int[sequence.length+1];
        
        for(int i = 0; i < sequence.length; i++) {
            dp[i+1] = dp[i] + sequence[i];
        }
        
        length = sequence.length + 1;
        answer = new int[2];
        for(int i = 1; i <= sequence.length; i++) { // 앞쪽부터 lastIdx를 순회
            binarySearch(sequence, k, i);
        }

        return answer;
    }
    
    public void binarySearch(int[] sequence, int k, int lastIdx) {
        int start = 0;
        int end = lastIdx - 1;
        
        while(start <= end) {
            int mid = (start+end)/2;
            
            if(dp[lastIdx] - dp[mid] == k) {
                if(length > lastIdx - mid) {
                    length = lastIdx - mid;
                    answer = new int[]{mid, lastIdx-1};
                }
                return; 
            }
            else if(dp[lastIdx] - dp[mid] > k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}