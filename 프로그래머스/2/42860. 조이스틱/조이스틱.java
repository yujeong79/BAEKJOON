import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int index;
        int move = name.length() - 1; // 최대 움직임의 수
        
        for(int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            // 'A'가 아닌 문자의 위치 찾기
            index = i + 1;
            while(index < name.length() && name.charAt(index) == 'A') {
                index++;
            }
            
            move = Math.min(move, i*2 + name.length() - index);
            move = Math.min(move, (name.length() - index) * 2 + i);
            
            
        }
        
        return answer + move;
    }
}