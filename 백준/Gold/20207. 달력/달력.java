import java.io.*;
import java.util.*;

public class Main {
	public static class Schedule implements Comparable<Schedule> {
		int s, e;
		
		public Schedule(int s, int e) {
			this.s = s;
			this.e = e;
		}
		
		@Override
		public int compareTo(Schedule other) {
			if(this.s == other.s)
				return (other.e - other.s) - (this.e - this.s);
			
			return this.s - other.s;
		}
	}
	
	static int N, answer;
	static int[] calendar;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 일정의 개수, 1 ≤ N ≤ 1000
        
        PriorityQueue<Schedule> schedules = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	int S = Integer.parseInt(st.nextToken()); // 1 ≤ S ≤ E ≤ 365
        	int E = Integer.parseInt(st.nextToken());
        	schedules.add(new Schedule(S, E));
        }
        
        calendar = new int[367];
        while(!schedules.isEmpty()) {
        	Schedule curr = schedules.poll();
        	for(int i = curr.s; i <= curr.e; i++) {
        		calendar[i]++;
        	}
        }

        answer = 0;
        int startCol = 0;
        int endCol = 0;
        int height = 0;
        
        for(int i = 1; i <= 366; i++) {
        	if(calendar[i] > 0) {
        		if(startCol == 0) startCol = i;
        		
        		endCol = i;
        		height = Math.max(height, calendar[i]);
        	} 
        	
        	else {
        		answer += (endCol - startCol + 1) * height;
        		height = 0;
        		startCol = 0;
        		endCol = 0;
        	}
        }
        
        System.out.println(answer);
        
    }
}