import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int parent;
		List<Integer> children;
		
		public Node() {
			this.children = new ArrayList<>();
		}
	}
	
	static Node[] tree;
	static int removedNode, answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1 <= N <= 50
		
		tree = new Node[N];
		for(int i = 0; i < N; i++) {
			tree[i] = new Node();
		}
		
		int start = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			tree[i].parent = Integer.parseInt(st.nextToken());
			if(tree[i].parent == -1) {
				start = i;
				continue;
			}
			
			tree[tree[i].parent].children.add(i);
		}
		
		removedNode = Integer.parseInt(br.readLine());
		
		if(start != removedNode)
			dfs(start);
		
		System.out.println(answer);
	}
	
	public static void dfs(int curr) {
		if(tree[curr].children.isEmpty()) {
			answer++;
			return;
		}
		
		if(tree[curr].children.size() == 1 && tree[curr].children.contains(removedNode)) {
			answer++;
			return;
		}
		
		for(int child : tree[curr].children) {
			if(child == removedNode) continue;
			
			dfs(child);
		}
	}
}