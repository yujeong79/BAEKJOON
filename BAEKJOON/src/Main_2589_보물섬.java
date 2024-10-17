import java.io.*;
import java.util.*;

public class Main_2589_보물섬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, minDist;
	static char[][] map;
	static Queue<int[]> queue;
	
	public static void init() {
		map = new char[N][M];
		queue = new LinkedList<>();
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		init();
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'L') queue.add(new int[] {i, j});
			}
		}
		
		// 이중 for문을 또 만들지 말고 Queue에 육지의 좌표를 넣고 하나씩 뽑는게 나을까?
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			BFS(curr[0], curr[1]);
		}
		
		System.out.println(minDist);
		
	} // end of main
	
	private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	private static void BFS(int r, int c) {
		boolean[][] isVisited = new boolean[N][M];
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c});
		isVisited[r][c] = true;
		
		int dist = 0;
		
		while(!queue.isEmpty()) {
			int qSize = queue.size();
			
			for(int i = 0; i < qSize; i++) {
				int[] curr = queue.poll();
				
				for(int d = 0; d < 4; d++) {
					int nr = curr[0] + dir[d][0];
					int nc = curr[1] + dir[d][1];
					
					if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 'L' && !isVisited[nr][nc]) {
						queue.add(new int[] {nr, nc});
						isVisited[nr][nc] = true;
					}
				}
			}
			
			dist++;

		}
		
		minDist = Math.max(minDist, dist-1);
		
	}
	
} // end of class
