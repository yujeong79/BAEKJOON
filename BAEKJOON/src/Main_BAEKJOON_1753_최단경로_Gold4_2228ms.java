import java.io.*;
import java.util.*;

public class Main_BAEKJOON_1753_최단경로_Gold4_2228ms {
	static class Node {
		int node, weight;

		public Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static final int INFINITY = Integer.MAX_VALUE;
	
	static int V, E, K; // (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000)
	static List<Node>[] adjList;
	static int[] distance;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		K = Integer.parseInt(br.readLine()); // 시작 정점의 번호
		
		adjList = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Node(to, weight));
		}
		
		distance = new int[V+1];
		Arrays.fill(distance, INFINITY);
		
		dijkstra(K);
		
		for(int i = 1; i <= V; i++) {
			if(distance[i] == INFINITY) sb.append("INF\n");
			else sb.append(distance[i] + "\n");
		}
		
		System.out.println(sb);
		
	} // end of main

	private static void dijkstra(int start) {
		distance[start] = 0;
		
		boolean[] isVisited = new boolean[V+1];
		
		for(int i = 1; i <= V; i++) {
			int min = INFINITY;
			int curr = -1;
			
			for(int j = 1; j <= V; j++) {
				if(!isVisited[j] && distance[j] < min) {
					min = distance[j];
					curr = j;
				}
			}
			
			if(curr == -1) break;
			
			isVisited[curr] = true;
			
			for(Node n : adjList[curr]) {
				if(!isVisited[n.node] && distance[n.node] > distance[curr]+n.weight) {
					distance[n.node] = distance[curr]+n.weight;
				}
			}
		}
		
	}
	
} // end of class
