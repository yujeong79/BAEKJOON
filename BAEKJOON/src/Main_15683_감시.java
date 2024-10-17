import java.io.*;
import java.util.*;

/**
 * 1 : 한 방향, 2 : 양 방향, 3 : 직각 방향, 4 : 세 방향, 5 : 네 방향
 * 
 * 0. 1,2,3,4,5 각 카메라마다 가능한 방향 조합을 구하고
 * 1. 각 CCTV의 가능한 방향으로 감시할 수 있는 칸을 세서 더 많은 칸을 감시할 수 있는 방향을 저장
 * 2. 방향이 정해지면 해당 방향을 #으로 바꾸기
 * 
 * 모든 카메라가 1과 2의 과정을 거쳤으면 이제 deadZone 반환
 *
 */

public class Main_15683_감시 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, deadZone;
	static int[][] map;
	static Queue<int[]> queue;
	
	public static void init() {
		queue = new LinkedList<>(); // CCTV의 위치를 담아둘 큐 초기화
		map = new int[N][M]; // 맵 초기화
		deadZone = N*M; // 사각지대 수 초기화
	}
	
	public static void main(String[] args) throws IOException {
		String str = br.readLine(); // (1 ≤ N, M ≤ 8)
		N = str.charAt(0)-'0';
		M = str.charAt(2)-'0';
		
		init();
		
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			for(int j = 0, ci = 0; j < M; j++, ci += 2) {
				map[i][j] = str.charAt(ci) - '0';

				if(map[i][j] > 0) deadZone--; // 사각지대의 수에서 벽과 CCTV의 수는 뺀다.
				
				if(map[i][j] > 0 && map[i][j] < 6) { 
					queue.add(new int[] {i, j}); // CCTV의 위치를 저장해놓는다.
				}
			}
		}
		
//		while(!queue.isEmpty()) {
//			int[] curr = queue.poll();
//			
//			selectDir(curr[0], curr[1]);
//			
//		}
		
		System.out.println(deadZone);
		
	} // end of main
	
	static final int[][][] monitorDir = {
			{{0}, {1}, {2}, {3}}, // CCTV 1
			{{0, 1}, {2, 3}}, // CCTV 2
			{{0, 2}, {0, 3}, {1, 2}, {1, 3}}, // CCTV 3
			{{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}}, // CCTV 4
			{{0, 1, 2, 3}} // CCTV 5
	};
	
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


} // end of class
