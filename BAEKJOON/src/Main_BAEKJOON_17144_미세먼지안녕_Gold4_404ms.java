import java.io.*;
import java.util.*;

public class Main_BAEKJOON_17144_미세먼지안녕_Gold4_404ms {
	static class Dust {
		int r, c, amount, spreadCnt;

		public Dust(int r, int c, int amount) {
			this.r = r;
			this.c = c;
			this.amount = amount;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static final int[] upward = {3, 0, 2, 1}; // 우, 상, 좌, 하
	static final int[] downward = {3, 1, 2, 0}; // 우, 하, 좌, 상
	
	static int R, C, T;
	static int[][] map;
	static List<Integer> airPurifier; // 공기청정기의 행 위치 저장하기
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken()); // T초가 지난 후
		
		airPurifier = new ArrayList<>();
		map = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) airPurifier.add(i);
			}
		}
		
		while(--T >= 0) {
			spread(); // 미세먼지 확산
			operatrion(); // 공기청정기 작동
		}
		
		int total = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] != -1) total += map[i][j];
			}
		}
		
		System.out.println(total);
	} // end of main

	private static void operatrion() {
		int[][] temp = new int[R][C];
		for(int i = 0; i < R; i++) {
			temp[i] = map[i].clone();
		}
		
		int d = 0;
		int r = airPurifier.get(0) + dir[upward[d]][0];
		int c = 0 + dir[upward[d]][1];
		
		while(map[r][c] != -1) {
			int nextR = r + dir[upward[d]][0];
			int nextC = c + dir[upward[d]][1];
			
			if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) {
				d = d+1%4;
				nextR = r + dir[upward[d]][0];
				nextC = c + dir[upward[d]][1];
			}
			
			if(map[nextR][nextC] != -1)
				temp[nextR][nextC] = map[r][c];
			
			r = nextR;
			c = nextC;
		}
		
		d = 0;
		r = airPurifier.get(1) + dir[downward[d]][0];
		c = 0 + dir[downward[d]][1];
		
		while(map[r][c] != -1) {
			int nextR = r + dir[downward[d]][0];
			int nextC = c + dir[downward[d]][1];
			
			if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) {
				d = d+1%4;
				nextR = r + dir[downward[d]][0];
				nextC = c + dir[downward[d]][1];
			}
			
			if(map[nextR][nextC] != -1)
				temp[nextR][nextC] = map[r][c];
			
			r = nextR;
			c = nextC;
		}
		
		for(int i = 0; i < R; i++) {
			map[i] = temp[i].clone();
		}
		map[airPurifier.get(0)][1] = map[airPurifier.get(1)][1] = 0;
	}

	private static void spread() {
		Queue<Dust> queue = new LinkedList<>();
		
		for(int i = 0; i < R; i++) { // 확산되기 이전 미세먼지 있는 곳의 좌표와 그 양을 queue에 저장
			for(int j = 0; j < C; j++) {
				if(map[i][j] > 0) 
					queue.add(new Dust(i, j, map[i][j]));
			}
		}
		
		while(!queue.isEmpty()) {
			Dust curr = queue.poll();
			int amountOfDustSpread = curr.amount/5;
			
			for(int d = 0; d < 4; d++) { // 인접한 네 방향으로 확산
				int r = curr.r + dir[d][0];
				int c = curr.c + dir[d][1];
				
				if(r >= 0 && r < R && c >= 0 && c < C && map[r][c] != -1) { // 범위 내에 있고 공기청정기가 없으면 
					map[r][c] += amountOfDustSpread; // 확산
					curr.spreadCnt++; // 남은 미세먼지의 양
				}
			}
			
			map[curr.r][curr.c] -= curr.spreadCnt * amountOfDustSpread;
		}
	}
	
} // end of class
