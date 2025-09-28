import java.util.*;
import java.io.*;

public class Main {
	static List<Integer>[] relations;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 사람의 수, 5 ≤ N ≤ 2000
		int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수, 1 ≤ M ≤ 2000
		
		relations = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			relations[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			
			relations[p1].add(p2);
			relations[p2].add(p1);
		}
		
		int answer = 0;
		isVisited = new boolean[N];
		for(int i = 0; i < N; i++) {
			if(dfs(i, 0)) {
				answer = 1;
				break;
			}
		}
		
		System.out.println(answer);
		
	}
	
	public static boolean dfs(int curr, int cnt) {
		if(cnt == 5) {
			return true;
		}
		
		for(int next : relations[curr]) {
			if(!isVisited[next]) {
				isVisited[next] = true;
				if(dfs(next, cnt+1)) {
					return true;
				}
				
				isVisited[next] = false; // 원상복귀
			}
		}
		
		return false;
	}
}