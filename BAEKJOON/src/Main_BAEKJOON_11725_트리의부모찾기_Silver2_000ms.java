import java.io.*;
import java.util.*;

public class Main_BAEKJOON_11725_트리의부모찾기_Silver2_000ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static List<Integer>[] adjList;
	static boolean[] isVisited;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		isVisited = new boolean[N+1];
		adjList = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			adjList[node1].add(node2);
			adjList[node2].add(node1);
		}
		
		BFS(1);
		
		for(int i = 2; i <= N; i++) {
			sb.append(parent[i] + "\n");
		}
		
		System.out.println(sb);
	} // end of main

	private static void BFS(int root) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(root);
		isVisited[root] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			
			for(int child : adjList[n]) {
				if(!isVisited[child]) {
					queue.add(child);
					isVisited[child] = true;
					
					parent[child] = n;
				}
			}
		}
	}
	
} // end of class
