import java.io.*;
import java.util.*;

/**
 * 1. BFS로 가장 가까운 물고기를 찾아서 리스트에 넣는다.
 * 	거리가 가까운 물고기가 많다면 가장 위에 있으면서 가장 왼쪽에 있는 순으로 정렬하여 첫번째 물고기를 먹는다.
 * 
 * 2. 이동한 거리만큼 time을 더한다.
 * 3. 다시 그 위치부터 BFS 탐색을 시작한다.	(물고기를 다 먹었거나 BFS를 돌렸는데 먹을 수 있는 물고기가 없는 경우 엄마 상어에게 도움을 요청한다.)
 * 
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
	static int N, callMom;
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
					map[i][j] = 0; // 처음 상어의 위치는 물고기가 아니므로 물고기의 크기를 0으로 바꿔놓자
					shark.r = i;
					shark.c = j;
					shark.size = 2;
				}
			}
		}
		
		while(true) {
			if(!BFS(shark.r, shark.c)) { // 현재 상어의 위치에서부터 탐색해서 먹을 수 있는 물고기가 이제 없다면
				break;
			}
		}
		
		System.out.println(callMom);
		
	} // end of main

	private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	private static boolean BFS(int r, int c) {
		boolean[][] isVisited = new boolean[N][N];
		List<Fish> eatableFish = new ArrayList<>(); // 먹을 수 있는 물고기의 좌표를 저장하자
		
		Queue<Fish> queue = new LinkedList<>();
		queue.add(new Fish(r, c)); // 처음 상어의 위치는 물고기가 없으므로 size를 0으로 하자
		isVisited[r][c] = true;
		
		int dist = 0;
		
		while(!queue.isEmpty()) {
			int qSize = queue.size();
			
			for(int i = 0; i < qSize; i++) {
				Fish curr = queue.poll();
			
				for(int d = 0; d < 4; d++) {
					int nr = curr.r + dir[d][0];
					int nc = curr.c + dir[d][1];
					
					if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] <= shark.size && !isVisited[nr][nc]) {
						Fish next = new Fish(nr, nc);
						queue.add(next);
						isVisited[nr][nc] = true;
						
						if(map[nr][nc] >= 1 && map[nr][nc] < shark.size) { // 먹을 수 있는 물고기면
							eatableFish.add(next); // 먹을 수 있는 목록에 추가
						}
					}
				}
			}
			
			dist++;
			
			if(eatableFish.size() > 0) { // 먹을 수 있는 물고기가 있으면
				Collections.sort(eatableFish);
				
				Fish fish = eatableFish.get(0);
				
				map[fish.r][fish.c] = 0; // 아기상어가 먹어서 없앰
				shark.r = fish.r;
				shark.c = fish.c;
				shark.cnt++; // 먹은 물고기의 수 1 증가
				
				if(shark.cnt == shark.size) {
					shark.size++; // 자신의 크기 만큼 물고기를 먹으면 크기가 1 증가한다.
					shark.cnt = 0;
				}
				
				callMom += dist;
				return true;
			}
		}
		
		return false;
	}
	
} // end of class
