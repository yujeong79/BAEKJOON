import java.io.*;
import java.util.*;

public class Main_2056_작업 {
	static class Work {
		int num, time;

		public Work(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, minTime;
	static List<Integer>[] adjList;
	static int[] degree;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 수행해야 할 작업 (3 ≤ N ≤ 10000)
		
		degree = new int[N+1];
		
		adjList = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		Queue<Work> queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken()); // 해당 작업에 걸리는 시간
			
			int cnt = Integer.parseInt(st.nextToken()); // 선행 관계에 있는 작업의 개수, (0 ≤ 개수 ≤ 100)
			degree[i] = cnt;
			if(cnt == 0) {
				queue.add(new Work(i, time));
			}
			
			while(--cnt >= 0) {
				int work = Integer.parseInt(st.nextToken());
				adjList[i].add(work);
			}
		}
		
		minTime = Integer.MAX_VALUE;
		
		while(!queue.isEmpty()) {
			Work curr = queue.poll();
			
			minTime += curr.time;
			
			for(int w : adjList[curr.num]) {
				degree[w]--;
				
				
			}
			
		}
		
	} // end of main
} // end of class
