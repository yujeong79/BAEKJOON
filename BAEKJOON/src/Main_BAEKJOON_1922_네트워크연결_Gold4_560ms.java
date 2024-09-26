import java.io.*;
import java.util.*;

public class Main_BAEKJOON_1922_네트워크연결_Gold4_560ms {
	static class Edge implements Comparable<Edge>{
		int computer1, computer2, cost;

		public Edge(int com1, int com2, int cost) {
			this.computer1 = com1;
			this.computer2 = com2;
			this.cost = cost;
		}
		

		@Override
		public String toString() {
			return "(" + computer1 + ", " + computer2 + ") cost=" + cost + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, M;
	static Edge[] network;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 컴퓨터의 수 (1 ≤ N ≤ 1000)
		M = Integer.parseInt(br.readLine()); // 연결할 수 있는 선의 수
		
		parent = new int[N+1]; 
		
		network = new Edge[M];
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			network[i] = new Edge(a, b, c);
		}
		
		Arrays.sort(network); // 가중치를 기준으로 오름차순 정렬

		
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		int minCost = 0;
		int install = 0;
		
		for(int i = 0; i < M; i++) {
			if(install == N-1) break;
			
			int parentOfA = findset(network[i].computer1);
			int parentOfB = findset(network[i].computer2);
			
			if(parentOfA != parentOfB) {
				union(parentOfA, parentOfB);
				install++;
				minCost += network[i].cost;
			}
		}
		
		System.out.println(minCost);
	} // end of main

	private static void union(int parentOfA, int parentOfB) {
		parent[parentOfB] = parentOfA;
	}

	private static int findset(int computer) {
		if(computer != parent[computer])
			return parent[computer] = findset(parent[computer]);
		
		return computer;
	}
	
} // end of class
