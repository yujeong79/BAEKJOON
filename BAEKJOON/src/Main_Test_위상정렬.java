import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_Test_위상정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		List<Integer>[] adjList = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		int[] degree = new int[V+1]; // 각 노드의 선행 노드(진입 노드)를 저장하기 위한 배열
		
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adjList[A].add(B);
			degree[B]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= V; i++) {
			if(degree[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.println(curr);
			
			for(int w : adjList[curr]) {
				degree[w]--;
				
				if(degree[w] == 0) {
					queue.add(w);
				}
			}
		}
	}

	// 진출 노드, 진입 노드
	public static String input = "9 9\r\n"
			+ "1 4\r\n"
			+ "1 8\r\n"
			+ "2 3\r\n"
			+ "4 3\r\n"
			+ "8 5\r\n"
			+ "3 5\r\n"
			+ "5 6\r\n"
			+ "9 6\r\n"
			+ "6 7";
}