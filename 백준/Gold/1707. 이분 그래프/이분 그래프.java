import java.util.*;
import java.io.*;

public class Main {
	static int V, E;
	static List<Integer>[] nodes;
	static int[] isSelected; // 0 : 초기화 상태, 1 : 집합1, 2 : 집합2
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		while(K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken()); // 1 ≤ V ≤ 20,000
			E = Integer.parseInt(st.nextToken()); // 1 ≤ E ≤ 200,000
			
			nodes = new ArrayList[V+1];
			for(int i = 0; i <= V; i++) {
				nodes[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				
				nodes[n1].add(n2);
				nodes[n2].add(n1);
			}
			
			isSelected = new int[V+1]; 
			
			boolean isPossible = true;
			for(int i = 1; i <= V; i++) {
				if(!dfs(i)) {
					isPossible = false;
					break;
				}
			}
			
			sb.append(isPossible ? "YES\n" : "NO\n");
			
		} // end of test cases
		
		System.out.println(sb);
	}
	
	public static boolean dfs(int curr) {
		for(int next : nodes[curr]) {
			if(isSelected[next] == 0) {
				isSelected[next] = isSelected[curr] == 1 ? 2 : 1;
				
				if(!dfs(next)) {
					return false;
				}
			}
			
			else if(isSelected[next] == isSelected[curr]) {
				return false;
			}
		}
		
		return true;
	}
}