import java.io.*;
import java.util.*;

public class Main_BAEKJOON_2606_바이러스_Silver3 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int N; // 컴퓨터의 수, 정점의 수
	private static int M; // 컴퓨터의 쌍의 수, 간선의 수
	
	private static List<Integer>[] adj;
	private static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			adj[v1].add(v2);
			adj[v2].add(v1);
		}
		
		isVisited = new boolean[N+1];
		BFS(1);
		
		int cnt = 0;
		for(int i = 2; i <= N; i++) {
			if(isVisited[i]) cnt++;
		}
		
		System.out.println(cnt);
	} // end of main

	private static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(v);
		isVisited[v] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int w : adj[curr]) {
				if(!isVisited[w]) {
					queue.add(w);
					isVisited[w] = true;
				}
			}
		}
	}
	
} // end of class
