import java.io.*;
import java.util.*;

public class Main_7569_토마토 {
	static class Tomato {
		int h, r, c;

		public Tomato(int h, int r, int c) {
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int M, N, H, empty, day;
	static int[][][] box;
	static Queue<Tomato> queue;
	
	private static void init() {
		box = new int[H][N][M];
		empty = M*N*H; // 비어있는 칸의 수
		queue = new LinkedList<>();
		day = 0;
	}
	
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸의 수
		N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸의 수
		H = Integer.parseInt(st.nextToken()); // 상자의 높이
		
		init(); // 초기화 작업
		
		for(int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " "); // -1이 입력으로 들어오므로 StringTokenizer를 써야 함
				for(int c = 0; c < M; c++) {
					box[h][r][c] = Integer.parseInt(st.nextToken());
					if(box[h][r][c] == -1) empty--;
					else if(box[h][r][c] == 1) {
						queue.add(new Tomato(h, r, c));
						empty--;
					}
				}
			}
		}
		
		if(empty == 0) {
			System.out.println(0);
		} else {
			BFS();
			if(empty == 0) System.out.println(day);
			else System.out.println(-1);
		}
		
	} // end of main

	// 상, 하, 좌, 우, 윗층, 아랫층 
	static final int[][] dir = {{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}, {-1, 0, 0}, {1, 0, 0}};

	private static void BFS() {
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				Tomato curr = queue.poll();
				
				for(int d = 0; d < 6; d++) {
					int h = curr.h + dir[d][0];
					int r = curr.r + dir[d][1];
					int c = curr.c + dir[d][2];
					
					if(h >= 0 && h < H && r >= 0 && r < N && c >= 0 && c < M && box[h][r][c] == 0) {
						box[h][r][c] = 1;
						empty--;
						queue.add(new Tomato(h, r, c));
					}
				}
			}
			
			day++;
			
			if(empty <= 0) return;
		}
	}
	
} // end of class
