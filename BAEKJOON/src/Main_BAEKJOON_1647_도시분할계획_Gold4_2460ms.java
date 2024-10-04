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

public class Main_BAEKJOON_1647_도시분할계획_Gold4_2460ms {
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
		
		Arrays.sort(roads); // 유지비를 기준으로 오름차순
		
		for(int i = 1; i <= N; i++) { // 대표자 설정, 초기 상태는 자기 자신이 자신의 대표자
			parent[i] = i;
		}
		
		int minCost = 0; // 최소 유지 비용을 누적할 변수
		int selectedRoadCnt = 0; // 선택된 길의 수를 저장할 변수
		for(int i = 0; i < M; i++) {
			if(selectedRoadCnt == N-2) { // 최소 신장 트리 중 유지 비용이 가장 높은 간선을 제외하고 나머지 간선을 모두 선택
				break; // 이 상태에서는 간선의 유지비용이 가장 높은 집 하나를 다른 마을로 빼고 나머지 마을은 완성
			}
			
			int pHouse1 = findset(roads[i].house1);
			int pHouse2 = findset(roads[i].house2);
			
			if(pHouse1 != pHouse2) { // 둘이 서로 다른 대표자를 갖고 있다면 사이클이 돌지 않으므로 선택 가능
				union(pHouse1, pHouse2); // 둘이 연결하자
				minCost += roads[i].cost;
				selectedRoadCnt++; // 
			}
			
		}
		
		System.out.println(minCost);
	} // end of main

	private static void union(int pHouse1, int pHouse2) {
		parent[pHouse2] = pHouse1; // house2의 대표자 자리의 대표자 자리에 house1의 대표자를 넣어주자
	}

	private static int findset(int house) { // 대표자를 반환하고, 동시에 대표자를 설정하는 메소드
		if(parent[house] != house) { // 자신의 대표자가 자신이 아니면
			return parent[house] = findset(parent[house]); // 자신의 대표자 자리의 자신의 대표자의 대표자를 찾아서 저장
		}
		
		// 자신의 대표자가 본인이면 본인 반환
		return house; 
	}
	
} // end of class
