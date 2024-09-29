import java.io.*;
import java.util.*;

public class Main_BAEKJOON_14567_선수과목_Gold5_548ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static List<Integer>[] adjList;
	static int[] degree, terms;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 과목의 수
		M = Integer.parseInt(st.nextToken()); // 선수 조건의 수
		
		terms = new int[N+1];
		degree = new int[N+1];
		adjList = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
		
			adjList[A].add(B);
			degree[B]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) { // 선수과목의 수가 0인 과목을 queue에 넣기
			if(degree[i] == 0) {
				queue.add(i);
			}
		}
		
		int term = 0;
		while(!queue.isEmpty()) {
			int qSize = queue.size();
			term++;
			
			for(int i = 0; i < qSize; i++) {
				int curr = queue.poll();
				terms[curr] = term;
				
				for(int w : adjList[curr]) {
					degree[w]--;
					
					if(degree[w] == 0) {
						queue.add(w);
					}
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			sb.append(terms[i] + " ");
		}
		
		System.out.println(sb);
	} // end of main
} // end of class
