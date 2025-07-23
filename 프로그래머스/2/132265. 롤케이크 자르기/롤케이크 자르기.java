import java.util.*;

class Solution {
    HashSet<Integer> lSet;
    HashSet<Integer> rSet;
    
    public int solution(int[] topping) {
        int upper = findUpper(topping);
        System.out.println("upper : " + upper);
        
        int lower = findLower(topping);
        System.out.println("lower : " + lower);
        
        int answer = upper - lower;
        return answer;
    }
    
    public int findUpper(int[] topping) {
        int start = 0;
        int end = topping.length - 1;
        
        int answer = 0;
        while(start <= end) {
            int mid = (start+end)/2;
            
            isPossible(mid, topping);
            if(lSet.size() <= rSet.size()) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return answer;
    }
    
    public int findLower(int[] topping) {
        int start = 0;
        int end = topping.length - 1;
        
        int answer = topping.length - 1;
        while(start <= end) {
            int mid = (start + end)/2;
            
            isPossible(mid, topping);
            if(lSet.size() < rSet.size()) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return answer;
    }
    
    public void isPossible(int mid, int[] topping) {
        lSet = new HashSet<>();
        rSet = new HashSet<>();
        
        int lCnt = 0;
        int rCnt = 0;
        for(int i = 0; i < topping.length; i++) {
            if(i <= mid) lSet.add(topping[i]);
            else rSet.add(topping[i]);
        }
        
        System.out.println("철수가 먹는 토핑 수 : " + lSet.size() + ", 동생이 먹는 토핑 수 : " + rSet.size());
    }
}