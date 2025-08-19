import java.util.*;

class Solution {
    static HashMap<Long, Long> parents;
    
    public long[] solution(long k, long[] room_number) {
        parents = new HashMap<>();
        
        int size = room_number.length;
        long[] answer = new long[size];
        for(int i = 0; i < size; i++) {
            answer[i] = findParent(room_number[i]);
        }
        
        return answer;
    }
    
    public long findParent(long num) {
        if(!parents.containsKey(num)) {
            parents.put(num, num+1);
            return num;
        }
        
        parents.put(num, findParent(parents.get(num)));
        return parents.get(num);
    }
}