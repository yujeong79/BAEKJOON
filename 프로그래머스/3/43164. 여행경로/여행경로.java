/*
    3 <= 공항 수 <= 10_000
*/

import java.util.*;

class Solution {
    class Ticket {
        String departure;
        String arrival;
        
        public Ticket(String departure, String arrival) {
            this.departure = departure;
            this.arrival = arrival;
        }
        
        @Override
        public String toString() {
            return departure + " -> " + arrival;
        }
    }
    
    String[] answer;
    String[] result;
    Ticket[] ticket;
    boolean[] isSelected;
    
    public String[] solution(String[][] tickets) {
        // tickets = new String[][]{{"ICN", "BBB"}, {"BBB", "ICN"}, {"ICN", "AAA"}};
        
        answer = new String[tickets.length + 1];
        result = new String[tickets.length + 1];
        ticket = new Ticket[tickets.length];
        isSelected = new boolean[tickets.length];
        for(int i = 0; i < tickets.length; i++) {
            ticket[i] = new Ticket(tickets[i][0], tickets[i][1]);
        }
        
        Arrays.sort(ticket, (o1, o2) -> {
           if(o1.arrival.equals(o2.arrival))
               return o2.departure.compareTo(o1.departure);
            
            return o2.arrival.compareTo(o1.arrival); 
        });
        
        dfs(0, "ICN");
        
        return answer;
    }
    
    public void dfs(int idx, String curr) {
        if(idx >= answer.length) {
            for(String r : result) {
                if(r == null) return;
            }
            
            // System.out.println(Arrays.toString(result));
            answer = result.clone();
            return;
        }
        
        result[idx] = curr;

        for(int i = 0; i < ticket.length; i++) {
            if(!isSelected[i] && ticket[i].departure.equals(curr)) {
                isSelected[i] = true;
                dfs(idx+1, ticket[i].arrival);
                
                isSelected[i] = false;
            }
        }
        
        dfs(idx+1, null);
    }
    
}