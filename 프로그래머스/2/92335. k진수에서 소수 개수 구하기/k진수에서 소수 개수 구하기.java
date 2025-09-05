import java.util.*;

/*
    시간초과를 해결하자
*/

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String result = "";
        while(n >= k) {
            result = (n % k) + result;
            n /= k;
        }
        result = n + result;
        
        StringTokenizer st = new StringTokenizer(result, "0");
        while(st.hasMoreTokens()) {
            long num = Long.parseLong(st.nextToken());
            if(num != 1 && isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(long num) {
        long div = 2;
        // div의 수를 줄여야한다.
        while(div*div <= num) {
            if(num % div == 0) 
                return false;
            
            div++;
        }
        
        return true;
    }
}