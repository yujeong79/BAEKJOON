import java.io.*;
import java.util.*;

/**
 * 크루스칼 알고리즘 
 */

public class Main_1197_최소스패닝트리 {
	static class Edge implements Comparable<Edge> {
		int V1, V2, W;

		public Edge(int v1, int v2, int w) {
			V1 = v1;
			V2 = v2;
			W = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.W - o.W;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int V, E;
	static Edge[] edges;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken()); // 정점의 개수 (1 ≤ V ≤ 10,000)
		E = Integer.parseInt(st.nextToken()); // 간선의 개수 (1 ≤ E ≤ 100,000)
		
		//////////////////////////////////////////////////////////////////
		// 초기화 작업
		edges = new Edge[E];
		p = new int[V+1];
		//////////////////////////////////////////////////////////////////
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(v1, v2, w);
		}
		
		Arrays.sort(edges);
		
		for(int i = 1; i <= V; i++) {
			p[i] = i;
		}
		
		int pickedEdgeCnt = 0;
		int minWeight = 0;
		
		for(int i = 0; i < E; i++) {
			int p1 = findset(edges[i].V1);
			int p2 = findset(edges[i].V2);
			
			if(p1 != p2) {
				union(p1, p2);
				pickedEdgeCnt++;
				minWeight += edges[i].W;
			}
		}
		
		System.out.println(minWeight);
	} // end of main

	private static void union(int p1, int p2) {
		p[p2] = p1;
	}

	private static int findset(int v) {
		if(p[v] != v) {
			return p[v] = findset(p[v]);
		}
		return v;
	}
	
} // end of class
