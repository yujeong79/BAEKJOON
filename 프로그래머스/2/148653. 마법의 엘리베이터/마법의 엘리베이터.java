import java.util.*;

/*
    마법의 돌을 최소한으로 사용하여 0층으로 내려가기
*/

class Solution {
    public int solution(int storey) {
        int answer = 0;
        int curr = storey;
        
        while(curr > 0) {
            int num = curr % 10;
            curr /= 10;
            
            if(num == 0) continue;
            
            if(num > 5) {
                answer += 10 - num;
                curr++;
            } else if(num < 5) {
                answer += num;
            } else {
                answer += 5;
                if(curr % 10 >= 5) curr++;  // 다음 자리가 5 이상이면 올림
            }
        }
        
        return answer;
    }
}