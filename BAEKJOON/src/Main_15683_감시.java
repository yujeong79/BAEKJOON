import java.io.*;
import java.util.*;

/**
 * 1 : 한 방향, 2 : 양 방향, 3 : 직각 방향, 4 : 세 방향, 5 : 네 방향
 * 
 * 백트래킹을 사용해서 
 */

public class Main_15683_감시 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, deadZone, monitor;
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
		
		
		System.out.println(deadZone);
		
	} // end of main
	
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

} // end of class
