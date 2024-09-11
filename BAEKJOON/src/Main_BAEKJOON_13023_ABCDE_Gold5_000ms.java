import java.io.*;
import java.util.*;
/**
 * 깊이우선으로 풀어야함
 */                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
public class Main_BAEKJOON_13023_ABCDE_Gold5_000ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, M;
	static List<Integer>[] adjList;
	static boolean[] isVisited;
	
	static int minSize = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int From = Integer.parseInt(st.nextToken());
			int To = Integer.parseInt(st.nextToken());
			
			adjList[From].add(To);
			adjList[To].add(From);
			
			minSize = adjList[From].size() >= adjList[To].size() ? Math.min(adjList[To].size(), minSize) : Math.min(adjList[From].size(), minSize); 
		}
		
		//System.out.println(minSize);
		
		int answer = 1;
		for(int i = 0; i < N; i++) {
			if(adjList[i].size() == minSize) {
				isVisited = new boolean[N];
				BFS(i);
				//System.out.println(Arrays.toString(isVisited));
				for(int j = 0; j < N; j++) {
					if(!isVisited[j]) {
						answer = 0;
						break;
					}
				}
				if(answer == 1) break;
			}
		}
		
		System.out.println(answer);
	} // end of main

	private static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		isVisited[start] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int n : adjList[curr]) {
				if(!isVisited[n]) {
					queue.add(n);
					isVisited[n] = true;
				}
			}
		}
	}
	
} // end of class
