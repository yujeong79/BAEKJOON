import java.io.*;
import java.util.*;

/**
 * 모든 노드들을 순회하면서 지름 구하기
 */

public class Main_BAEKJOON_1967_트리의지름_000ms {
	static class Node { // 각 노드에는 본인과 자식들 간의 가중치를 각각 저장
		List<Weight> children = new ArrayList<>();
		
		public Node() {}
	}
	
	static class Weight {
		int next;
		int weight;
		
		public Weight(int next, int weight) {
			this.next = next;
			this.weight = weight;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, halfdiameter, maxDiameter;
	static Node[] tree;
	
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		maxDiameter = 0;
		tree = new Node[N+1];
		
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if(tree[parent] == null) tree[parent] = new Node();
			tree[parent].children.add(new Weight(child, weight));
		}
		
		// tree[i]가 null이면 자식이 없다는 것을 의미
		for(int t = 1; t <= N; t++) {
			if(tree[t] != null && tree[t].children.size() >= 2) {
				List<Integer> halfdiameterList = new ArrayList<>();
				
				for(Weight w : tree[t].children) {
					halfdiameter = 0;
					DFS(w.next, w.weight);
					halfdiameterList.add(halfdiameter);
				}
	
				Collections.sort(halfdiameterList, Collections.reverseOrder());
				maxDiameter = Math.max(halfdiameterList.get(0) + halfdiameterList.get(1), maxDiameter);
			}
		}
		
		System.out.println(maxDiameter);
		
	} // end of main

	private static void DFS(int curr, int length) {
		if(tree[curr] == null) { // 자식이 없으면 종료
			halfdiameter = Math.max(halfdiameter, length);
			return;
		}
		
		for(Weight w : tree[curr].children) {
			DFS(w.next, length + w.weight);
		}
	}

	
} // end of class
