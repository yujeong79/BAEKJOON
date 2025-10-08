import java.util.*;

class Solution {
    public int solution(int n, int k) {
        // k진수로 바꾸기
        String result = "";
        while(n >= k) {
            result = (n % k) + result;
            n /= k;
        }
        result  = n + result;
        
        StringTokenizer st = new StringTokenizer(result, "0");
        int answer = 0;
        while(st.hasMoreTokens()) {
            if(isPrime(Long.parseLong(st.nextToken()))) 
                answer++;
        }
        
        System.out.println(result);
        return answer;
    }
    
    public boolean isPrime(long num) {
        if(num == 1) 
            return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) 
                return false;
        }
        
        return true;
    }
}