import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_Test_다익스트라_반복문 {
	static class Node {
		int node, weight;

		public Node(int v, int w) {
			this.node = v;
			this.weight = w;
		}
	}
	
	static final int INFINITY = Integer.MAX_VALUE;
	
	static int V, E;
	static List<Node>[] adjList;
	static int[] distance;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt(); // 정점의 개수
		E = sc.nextInt(); // 간선의 개수
		
		adjList = new ArrayList[V];
		for(int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			int From = sc.nextInt();
			int To = sc.nextInt();
			int weight = sc.nextInt();
			adjList[From].add(new Node(To, weight));
		}
		
		// 1. 시작노드에서부터 각 노드까지의 거리를 무한대로 초기화하기
		distance = new int[V];
		Arrays.fill(distance, INFINITY);
		
		// 다익스트라 시작 : 시작노드가 parameter
		dijkstra(0);
		
		System.out.println(Arrays.toString(distance));
	}

	private static void dijkstra(int start) {
		distance[start] = 0; // 2. 시작노드의 거리를 0으로 갱신
		
		boolean[] isVisited = new boolean[V];
		
		for(int i = 0; i < V; i++) { // 노드의 수만큼 반복
			int min = INFINITY;
			int curr = -1;
			
			for(int j = 0; j < V; j++) {
				if(!isVisited[j] && distance[j] < min) { // 3. 아직 방문하지 않은 노드들 중에 가장 가까운 거리의 노드를 선택
					min = distance[j];
					curr = j;
				}
			}
			
			if(curr == -1) break; // 더 이상 갈 수 있는 노드가 없음
			
			isVisited[curr] = true;
			
			for(Node child : adjList[curr]) { // 4. 선택된 현재 노드의 자식 노드들의 거리를 최솟값으로 갱신
				if(!isVisited[child.node] && distance[child.node] > distance[curr]+child.weight) {
					distance[child.node] = distance[curr]+child.weight;
				}
			}
		}
		
	}

	static String input = "6 11\r\n"
			+ "0 1 4\r\n"
			+ "0 2 2\r\n"
			+ "0 5 25\r\n"
			+ "1 3 8\r\n"
			+ "1 4 7\r\n"
			+ "2 1 1\r\n"
			+ "2 4 4\r\n"
			+ "3 0 3\r\n"
			+ "3 5 6\r\n"
			+ "4 3 5\r\n"
			+ "4 5 12";
}