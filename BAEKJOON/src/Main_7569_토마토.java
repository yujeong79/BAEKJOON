import java.io.*;
import java.util.*;

public class Main_7569_토마토 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int M, N, H, empty, unripen, ripen;
	static int[][][] box;
	
	private static void init() {
		box = new int[H][N][M];
		empty = M*N*H; // 비어있는 칸의 수
		ripen = 0; // 익은 토마토의 수
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
						ripen++;
						empty--;
					}
				}
			}
		}
		
		if(empty == 0) {
			System.out.println(0);
		}
		
	} // end of main
} // end of class
