import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        TreeMap<Integer, Queue<Integer>> tMap = new TreeMap<>();
        for(String record : records) {
            StringTokenizer st = new StringTokenizer(record, " ");
            String time = st.nextToken();
            int carNum = Integer.parseInt(st.nextToken());
            
            if(!tMap.containsKey(carNum)) {
                tMap.put(carNum, new LinkedList<Integer>());
            }
            
            st = new StringTokenizer(time, ":");
            int minutes = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
            tMap.get(carNum).add(minutes);
        }
        
        int[] answer = new int[tMap.size()];
        int idx = 0;
        for(Map.Entry<Integer, Queue<Integer>> entry : tMap.entrySet()) {
            Queue<Integer> record = entry.getValue();
            
            double total = 0.;
            double fee = 0;
            while(!record.isEmpty()) {
                int IN = record.poll();
                int OUT;
                if(record.isEmpty()) OUT = 23*60 + 59;
                else OUT = record.poll();
                
                total += OUT - IN;
            }
            
            total -= fees[0]; fee += fees[1];
            
            if(total > 0)
                fee += Math.ceil(total / fees[2]) * fees[3];
            
            answer[idx++] = (int) fee;
        }

        return answer;
    }
}