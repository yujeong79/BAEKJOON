import java.util.*;
import java.io.*;

public class Main {
	static int N, M; // 1 <= N, M <= 500
	static int[][] map;
	static int[][] routes;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		routes = new int[N][M];
		for(int i = 0; i < N; i++) {
			Arrays.fill(routes[i], -1);
		}
		
		dfs(0, 0);
		
		System.out.println(routes[0][0]);
	}
	
	public static int dfs(int r, int c) {
		if(r == N-1 && c == M-1) {
			return 1;
		}
		
		if(routes[r][c] != -1) { // 해당 지점에서 경로가 있다면 반환, 여기 if문에 걸린다는 것은 이미 이 지점에서 목적지까지 가능한 경로를 모두 찾은 후이다. 
			return routes[r][c];
		}
		
		routes[r][c] = 0;
		for(int d = 0; d < 4; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[r][c] <= map[nr][nc]) 
				continue;
			
			routes[r][c] += dfs(nr, nc);
		}
		
		return routes[r][c];
	}
}