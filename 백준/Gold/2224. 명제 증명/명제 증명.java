import java.io.*;
import java.util.*;

public class Main {
	static PriorityQueue<String> pq = new PriorityQueue<>();
	static Set<Integer>[] nodes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		nodes = new HashSet['z'-'A'+1];
		for(int i = 0; i < nodes.length; i++) {
			nodes[i] = new HashSet<>();
		}
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			char parent = str.charAt(0);
			char child = str.charAt(str.length()-1);
			
			nodes[parent-'A'].add(child-'A');
		}
		
		for(int i = 0; i < nodes.length; i++) {
			if(!nodes[i].isEmpty()) {
				findProposition(i);
			}
		}
		
		sb.append(pq.size()).append("\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static void findProposition(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] isVisited = new boolean['z'-'A'+1];
		queue.add(start);
		isVisited[start] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int next : nodes[curr]) {
				if(!isVisited[next]) {
					String proposition = (char)(start+'A') + " => " + (char)(next+'A');
                    isVisited[next] = true;
					pq.add(proposition);
					queue.add(next);
				}
			}
		}
	}
}