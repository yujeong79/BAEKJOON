import java.io.*;
import java.util.*;

public class Main_BAEKJOON_24444_너비우선탐색1_Silver2 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int N;
	private static int M;
	private static int K;
	
	private static List<Integer>[] adj;

	private static int[] isVisited;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 정점의 수
		M = Integer.parseInt(st.nextToken()); // 간선의 수
		K = Integer.parseInt(st.nextToken()); // 시작 정점
		
		adj = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			adj[v1].add(v2);
			adj[v2].add(v1);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(adj[i]);
		}
		
		isVisited = new int[N+1];
		BFS(K);
		
		for(int i = 1; i <= N; i++) {
			System.out.println(isVisited[i]);
		}
		
	} // end of main
	
	private static int order = 1;

	private static void BFS(int n) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(n);
		isVisited[n] = order++;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int w : adj[curr]) {
				if(isVisited[w] == 0) {
					queue.add(w);
					isVisited[w] = order++;
				}
			}
		}
	}
	
	
} // end of class
