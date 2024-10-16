import java.io.*;
import java.util.*;

/**
 * 
 * 맨 처음 아기상어의 크기는 2
 * 
 * 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
 * 먹을 수 있는 물고기가 2마리 이상이라면, 거리가 가장 가까운 물고기를 먹으러 간다.
 * 	- 거리가 가까운 물고기가 많다면 가장 위에 있는 물고기 -> 가장 왼쪽에 있는 물고기 순으로 먹는다.
 * 
 *  아기 상어가 1칸 이동하는데 1초가 걸린다.
 *  
 *  아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없다.
 *  아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 잇다.
 *  아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기가 1 증가한다.
 *  
 *  => 더 이상 먹을 수 없는 물고기가 공간에 없다면 아기 상어는 엄마 상어를 부른다.
 *  	1. 물고기가 더 이상 없는 경우
 *  	2. 남은 물고기의 크기가 자신의 크키와 같거나 큰 경우
 */

public class Main_16236_아기상어 {
	static class Fish implements Comparable<Fish>{
		int r, c, size, cnt;
		
		public Fish() {}
		
		public Fish(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Fish o) { // 가장 위에 있는 물고기 -> 가장 왼쪽에 있는 물고기 순으로 정렬
			if(this.r == o.r) return this.c - o.c;
			return this.r - o.r;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, fishCnt;
	static int[][] map;
	static Fish shark;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		shark = new Fish();
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) { // 상어의 위치와 사이즈 저장
					shark.r = i;
					shark.c = j;
					shark.size = 2;
				} else if(map[i][j] != 0) fishCnt++; // 물고기의 수 세어놓기
			}
		}
		
		BFS(shark.r, shark.c);
		
	} // end of main

	private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	private static void BFS(int r, int c) {
		boolean[][] isVisited = new boolean[N][N];
		List<Fish> eatableFish = new ArrayList<>(); // 먹을 수 있는 물고기의 좌표를 저장하자
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c}); // 처음 상어의 위치는 0으로 해두자
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int qSize = queue.size();
			
			for(int i = 0; i < qSize; i++) {
				int[] curr = queue.poll();
				
			
				for(int d = 0; d < 4; d++) {
					int nr = curr[0] + dir[d][0];
					int nc = curr[1] + dir[d][1];
					
					if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] <= shark.size && !isVisited[nr][nc]) {
						queue.add(new int[] {nr, nc});
						isVisited[nr][nc] = true;
						
						if(map[nr][nc] >= 1 && map[nr][nc] < shark.size) { // 먹을 수 있는 물고기면
							eatableFish.add(new Fish(nr, nc)); // 먹을 수 있는 목록에 추가
						}
					}
				}
			}
			
			if(eatableFish.size() > 0) { // 먹을 수 있는 물고기가 있으면
				Collections.sort(eatableFish);
				
				Fish fish = eatableFish.get(0);
				map[fish.r][fish.c] = 0; // 아기상어가 먹어서 없앰
				shark.r = fish.r;
				shark.c = fish.c;
				shark.cnt++; // 먹은 물고기의 수 1 증가
				
				if(shark.cnt == shark.size) shark.size++; // 자신의 크기만큼 물고기를 먹으면 크기가 1 증가한다.
			}
		}
	}
	
} // end of class
