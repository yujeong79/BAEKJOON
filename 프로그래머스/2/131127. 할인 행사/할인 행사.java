import java.util.*;

/*
    1 ≤ want의 길이 = number의 길이 ≤ 10
    10 ≤ discount의 길이 ≤ 100,000
*/

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wants = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            wants.put(want[i], number[i]);
        }
        
        int answer = 0;
        HashMap<String, Integer> items = new HashMap<>();
        for(int i = 0; i < discount.length; i++) {
            if(!items.containsKey(discount[i])) {
                items.put(discount[i], 0);
            }
            
            items.put(discount[i], items.get(discount[i]) + 1);
            if(i >= 10) {
                items.put(discount[i-10], items.get(discount[i-10])-1);
            }
            
            boolean flag = true;
            for(Map.Entry<String, Integer> entry : wants.entrySet()) {
                String curr = entry.getKey();
                if(!items.containsKey(curr) || items.get(curr) < wants.get(curr)) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) answer++;
        }

        return answer;
    }
}