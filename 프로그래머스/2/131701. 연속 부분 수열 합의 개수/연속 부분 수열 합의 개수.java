import java.util.*;

/*
    원형 수열의 연속 부분 수열 합으로 만들 수 있는 수의 개수를 Return
    
    3 ≤ elements의 길이 ≤ 1,000
    1 ≤ elements의 원소 ≤ 1,000
*/

class Solution {
    public int solution(int[] elements) {
        int size = elements.length;
        
        int[] sum = new int[size*2];
        for(int i = 1; i < sum.length; i++) {
            if(i < elements.length) {
                sum[i] = sum[i-1] + elements[i-1];
            } else {
                sum[i] = sum[i-1] + elements[(i-1)%size];
            }
        }
        
        HashSet<Integer> hSet = new HashSet<Integer>();
        
        for(int i = 1; i <= size; i++) {
            for(int j = i; j <= size+(i-1); j++) {
                hSet.add(sum[j] - sum[j-i]);
            }
        }
        
        return hSet.size();
    }
}