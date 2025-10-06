import java.util.*;
import java.io.*;

public class Main {
	static List<int[]>[] nodes;
	static boolean[] isVisited;
	static int start, max, answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine()); // 2 ≤ V ≤ 100,000
		nodes = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			nodes[i] = new ArrayList<>();
		}
		for(int i = 1; i <= V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			while(n2 != -1) {
				int d = Integer.parseInt(st.nextToken());
				nodes[n1].add(new int[]{n2, d});
				
				n2 = Integer.parseInt(st.nextToken());
			}
		}
		
		// 트리의 임의의 한 점에서 가장 먼 지점은 시작점
		isVisited = new boolean[V+1];
		dfs(1, 0); // 시작점 구하기
		
        // 시작점에서 가장 먼 노드와의 거리가 답
		isVisited = new boolean[V+1];
		dfs(start, 0);
		
		System.out.println(max);
	}
	
	public static void dfs(int curr, int sum) {
		isVisited[curr] = true;
		
		if(sum > max) {
			max = sum;
			start = curr;
		}
		
		for(int[] node : nodes[curr]) {
			int next = node[0];
			int dist = node[1];
			
			if(isVisited[next]) continue;
			
			dfs(next, sum + dist);
		}
	}
}