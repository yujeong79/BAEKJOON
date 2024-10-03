import java.io.*;
import java.util.*;

public class Main_2056_작업 {
	static class Work implements Comparable<Work>{
		int num, time, degree;
		boolean isSelected;
		List<Integer> list = new ArrayList<>();

		public Work(int num, int time, int degree) {
			this.num = num;
			this.time = time;
			this.degree = degree;
		}

		@Override
		public int compareTo(Work o) {
			return this.time - o.time;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, minTime;
	static Work[] works;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 수행해야 할 작업 (3 ≤ N ≤ 10000)
		
		works = new Work[N+1];
		PriorityQueue<Work> queue = new PriorityQueue<>();
		minTime = 0;
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken()); // 해당 작업에 걸리는 시간
			int d = Integer.parseInt(st.nextToken()); // 선행 관계에 있는 작업의 개수, (0 ≤ 개수 ≤ 100)
			
			works[i] = new Work(i, t, d); // works[i]는 i 작업에 대한 정보
			
			for(int j = 0; j < d; j++) { // 선행 작업들의 수만큼 반복하면서 선행 작업들 담기
				int p = Integer.parseInt(st.nextToken());
				works[p].list.add(i); // 해당 작업보다 선행되어야 하는 작업의 진출 리스트에 해당 작업 넣기
			}
			
			if(d == 0) { // 진입차수가 0인 작업들을 큐에 담기
				queue.add(works[i]);
				works[i].isSelected = true; // 방문 체크
				
				minTime = Math.max(minTime, works[i].time);
			}
		}
		
		
		while(!queue.isEmpty()) {
			Work curr = queue.poll();
			
			for(int next : works[curr.num].list) { // 진출리스트에서 하나씩 다음 작업 가져오기
				if(!works[next].isSelected) { // 아직 방문하지 않았다면
					works[next].degree--; // 차수 줄여주고
					
					if(works[next].degree == 0) {
						works[next].time += curr.time; 
						minTime = Math.max(minTime, works[next].time);
						queue.add(works[next]);
						works[next].isSelected = true;
					}
				}
			}
		}
		
		System.out.println(minTime);
	} // end of main
} // end of class


