import java.util.*;
import java.io.*;

public class Main {
	static class Edge {
		int next;
		int weight;
		
		Edge(int next, int weight) {
			this.next = next;
			this.weight = weight;
		}
	}
	
	static int n, m;
	static List<Edge>[] edges;
	static int[] items;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // 1 ≤ n ≤ 100
		m = Integer.parseInt(st.nextToken()); // 1 ≤ m ≤ 15
		int r = Integer.parseInt(st.nextToken()); // 1 ≤ r ≤ 100
		
		items = new int[n+1];
		edges = new ArrayList[n+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<>();
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			edges[n1].add(new Edge(n2, w));
			edges[n2].add(new Edge(n1, w));
		}
		
		int answer = 0;
		for(int i = 1; i <= n; i++) {
			answer = Math.max(answer, dijkstra(i));
		}
		
		System.out.println(answer);
	}
	
	public static int dijkstra(int start) {
		int[] weights = new int[n+1];
		Arrays.fill(weights, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			weights[curr[0]] = Math.min(weights[curr[0]], curr[1]);
			
			for(Edge edge : edges[curr[0]]) {
				if(curr[1] + edge.weight <= m) {
					pq.add(new int[] {edge.next, curr[1] + edge.weight});
				}
			}
		}
		
		int result = 0;
		for(int i = 1; i <= n; i++) {
			if(weights[i] != -1 && weights[i] <= m) result += items[i];
		}
		
		return result;
	}
}