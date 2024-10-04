import java.io.*;
import java.util.*;

public class Main_BAEKJOON_1916_최소비용구하기_Gold5_348ms {
	static class City {
		int city, cost;

		public City(int city, int cost) {
			this.city = city;
			this.cost = cost;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static final int INF = Integer.MAX_VALUE;
	
	static int N, M, departure, arrival;
	static List<City>[] busList;
	static int[] costList;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		M = Integer.parseInt(br.readLine()); // 버스의 개수
		
		busList = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			busList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			busList[from].add(new City(to, cost));
		}
	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		departure = Integer.parseInt(st.nextToken());
		arrival = Integer.parseInt(st.nextToken());
		
		costList = new int[N+1];
		Arrays.fill(costList, INF);
		
		dijkstra(departure);
		
		System.out.println(costList[arrival]);
	} // end of main

	private static void dijkstra(int start) {
		costList[start] = 0;
		
		boolean[] isVisited = new boolean[N+1];
		
		for(int i = 1; i <= N; i++) {
			int min = INF;
			int curr = -1;
			
			for(int j = 1; j <= N; j++) {
				if(!isVisited[j] && costList[j] < min) {
					min = costList[j];
					curr = j;
				}
			}
			
			if(curr == -1) break;
			
			isVisited[curr] = true;
			
			for(City c : busList[curr]) {
				if(!isVisited[c.city] && costList[c.city] > costList[curr]+c.cost) {
					costList[c.city] = costList[curr]+c.cost;
				}
			}
		}
		
	}
	
} // end of class	
