import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hMap = new HashMap<>();
            
        for(String[] cloth : clothes) {
            String name = cloth[0];
            String type = cloth[1];
            
            if(!hMap.containsKey(type)) {
                hMap.put(type, 0);
            }
        
            hMap.put(type, hMap.get(type) + 1);
        }
        
        int answer = 1;
        for(Map.Entry<String, Integer> entry : hMap.entrySet()) {
            answer *= entry.getValue() + 1;
        }
    
        return answer - 1;
    }
}