import java.io.*;
import java.util.*;

public class Main_BAEKJOON_10451_순열사이클_Silver3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static List<Integer>[] adjList;
	static boolean[] isVisited;
	static int cycle;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			N = Integer.parseInt(br.readLine());
			
			adjList = new ArrayList[N+1];
			for(int i = 1; i <= N; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= N; i++) {
				adjList[i].add(Integer.parseInt(st.nextToken()));
			}
			
			cycle = 0;
			isVisited = new boolean[N+1];
			
			for(int i = 1; i <= N; i++) {
				if(!isVisited[i]) {
					DFS(i);
					cycle++;
				}
			}
			
			sb.append(cycle + "\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void DFS(int start) {
		Stack<Integer> stack = new Stack<>();
		
		stack.add(start);
		
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			isVisited[curr] = true;
			
			for(int n : adjList[curr]) {
				if(!isVisited[n]) {
					stack.add(n);
				}
			}
		}
	}
	
} // end of class
