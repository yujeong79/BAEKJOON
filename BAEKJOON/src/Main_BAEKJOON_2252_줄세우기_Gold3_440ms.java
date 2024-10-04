import java.io.*;
import java.util.*;

public class Main_BAEKJOON_2252_줄세우기_Gold3_440ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static List<Integer>[] students;
	static int[] precedence;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		precedence = new int[N+1];
		students = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			students[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M ;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			students[A].add(B);
			precedence[B]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(precedence[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(curr + " ");
			
			for(int s : students[curr]) {
				precedence[s]--;
				
				if(precedence[s] == 0) {
					queue.add(s);
				}
			}
		}
		
		System.out.println(sb);
	} // end of main
} // end of class
