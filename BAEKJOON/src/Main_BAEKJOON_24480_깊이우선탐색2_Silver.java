import java.io.*;
import java.util.*;

public class Main_BAEKJOON_24480_깊이우선탐색2_Silver {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int N;
	private static int M;
	private static int R;
	
	private static List<Integer>[] adjList;
	private static int[] isVisited;
	
	private static int num;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 정점의 수
		M = Integer.parseInt(st.nextToken()); // 간선의 수
		R = Integer.parseInt(st.nextToken()); // 시작 정점
		
		isVisited = new int[N+1];
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
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(adjList[i], Collections.reverseOrder());
		}
		
		num = 1;
		DFS(R);
		
		for(int i = 1; i <= N; i++) {
			System.out.println(isVisited[i]);
		}
		
	}

	
	private static void DFS(int n) {
		isVisited[n] = num++;
		
		for(int w : adjList[n]) {
			if(isVisited[w] == 0)
				DFS(w);
		}
		
	}
}
