/*
    최소한의 객실만 사용하여 예약 손님을 받으려고 한다.
    한 번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소하고 다음 손님들이 사용 가능
*/
import java.util.*;

class Solution {
    class Booking implements Comparable<Booking> {
        int start;
        int end;
        
        public Booking (int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Booking other) {
            if(this.end == other.end)
                return this.start - other.start;
            
            return this.end - other.end;
        }
        
        @Override
        public String toString() {
            return start + " ~ " + end;
        }
    }
    
    public int solution(String[][] book_time) {
        // book_time = new String[][]{{"15:00", "17:55"}};
        
        Booking[] booking = new Booking[book_time.length];
        for(int i = 0; i < book_time.length; i++) {
            int[] time = new int[2];
            for(int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(book_time[i][j], ":");
                time[j] = Integer.parseInt(st.nextToken()) * 100;
                time[j] += Integer.parseInt(st.nextToken());
            }
            
            time[1] += 10;
            if(time[1] % 100 >= 60) {
                time[1] += 40;
            }
            
            booking[i] = new Booking(time[0], time[1]);
        }
        
        Arrays.sort(booking, (o1, o2) -> {
            if(o1.start == o2.start) 
                return o1.end - o2.end;
            
            return o1.start - o2.start;
        });
        System.out.println(Arrays.toString(booking));

        int answer = 1;
        int idx = 0;
        PriorityQueue<Booking> pq = new PriorityQueue<>();
        pq.add(booking[idx++]);
        while(idx < book_time.length) {
            Booking curr = booking[idx++];
            
            while(pq.size() > 0 && curr.start >= pq.peek().end && curr.end >= pq.peek().end) {
                pq.poll();
            }
            
            pq.add(curr);
            
            answer = Math.max(pq.size(), answer);
        }

        return answer;
    }
}