import java.io.*;
import java.util.*;

/**
 * 첫번째 아이디어 : 크루스칼 알고리즘으로 최소 유지 비용을 유지하면서
 * 	최소 유지 비용을 유지할 수 없는 경우(사이클이 만들어지는 경우)에는 다른 마을로 분리한다.
 * 	! 다른 마을로 분리했을 때 길이 이어지지 않는 경우에는 어떻게 처리하지? => 백트래킹으로 해보자
 * 
 * 참고 아이디어 : 크루스칼 알고리즘으로 최소 간선 트리를 구한다.
 * 	선택된 최소 간선 트리 중에서 유지 비용이 제일 큰 간선을 제외한다.
 */

public class Main_BAEKJOON_1647_도시분할계획_Gold4_000ms {
	static class Road implements Comparable<Road> {
		int house1, house2, cost;

		public Road(int house1, int house2, int cost) {
			this.house1 = house1;
			this.house2 = house2;
			this.cost = cost;
		}

		@Override
		public int compareTo(Road o) {
			return this.cost - o.cost;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static Road[] roads; 
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
		N = Integer.parseInt(st.nextToken()); // (2 ≤ N ≤ 100,000)
		M = Integer.parseInt(st.nextToken()); // (1 ≤ M ≤ 1,000,000)
		
		parent = new int[N+1];
		
		roads = new Road[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int house1 = Integer.parseInt(st.nextToken());
			int house2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			roads[i] = new Road(house1, house2, cost);
		}
		
		Arrays.sort(roads);
		
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		
		
		
	} // end of main
} // end of class
