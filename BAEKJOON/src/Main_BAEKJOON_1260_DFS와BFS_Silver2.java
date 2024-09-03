import java.io.*;
import java.util.*;

public class Main_BAEKJOON_1260_DFS와BFS_Silver2 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static boolean[] isVisited;
	private static List<Integer>[] adjList;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호
		
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
			Collections.sort(adjList[i]);
		}
		
		isVisited = new boolean[N+1];
		dfs(V);
		
		System.out.println();
		
		bfs(V);
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(v);
		isVisited[v] = false;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.print(curr + " ");
			
			for(int w : adjList[curr]) {
				if(isVisited[w]) {
					queue.add(w);
					isVisited[w] = false;
				}
			}
		}
		
	}

	private static void dfs(int v) {
		isVisited[v] = true;
		System.out.print(v + " ");
		
		for(int n : adjList[v]) {
			if(!isVisited[n]) {
				dfs(n);
			}
		}
	}
}
