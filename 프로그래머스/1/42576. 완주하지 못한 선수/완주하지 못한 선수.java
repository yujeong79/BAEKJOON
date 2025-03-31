import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hMap = new HashMap<String, Integer>();
        
        for(String p : participant) {
            if(hMap.containsKey(p)) {
                hMap.put(p, hMap.get(p) + 1);
            }
            else hMap.put(p, 1);
        }
        
        for(String c : completion) {
            hMap.put(c, hMap.get(c) - 1);
        }
        
        for(String key : hMap.keySet()) {
            if(hMap.get(key) > 0) {
                answer = key;
                break;
            }
        }


        return answer;
    }
}