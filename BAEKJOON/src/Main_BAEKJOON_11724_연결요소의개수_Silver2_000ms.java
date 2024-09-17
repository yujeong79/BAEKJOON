import java.io.*;
import java.util.*;

public class Main_BAEKJOON_11724_연결요소의개수_Silver2_000ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	static int N, M;
	static List<Integer>[] adjList;
	static boolean[] isVisited;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		adjList = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			adjList[node1].add(node2);
			adjList[node2].add(node1);
		}
		
		isVisited = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			if(!isVisited[i]) {
				DFS(i);
				count++;
			}
		}
		
		System.out.println(count);
		
	} // end of main

	private static void DFS(int node) {
		for(int n : adjList[node]) {
			if(!isVisited[n]) {
				isVisited[n] = true;
				DFS(n);
			}
		}
	}
	

} // end of class
