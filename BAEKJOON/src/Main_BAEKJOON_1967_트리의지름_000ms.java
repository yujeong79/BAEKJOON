import java.io.*;
import java.util.*;

public class Main_BAEKJOON_1967_트리의지름_000ms {
	static class Node {
		int parent;
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] tree;
	
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		tree = new int[N+1][N+1];
		
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			tree[node1][node2] = weight;
			tree[node2][node1] = weight;
		}
		
		
		
	} // end of main

	private static void DFS(int parent, int length) {
		//isVisited[parent] = true;
		
		for(int i = 1; i <= N; i++) {
			if(tree[parent][i] != 0) { // 가중치가 있다면, 즉 자식이 있다면
				DFS(i, length+tree[parent][i]);
			}
		}
		
	}
	
} // end of class
