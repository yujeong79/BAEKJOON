import java.io.*;
import java.util.*;

/**
 * 회전을 테트로미노가 아니라 맵을 회전시키면 되나?
 */
public class Main_14500_테트로미노 {
	static class Tetromino {
		int[] first;
		int[] second;
		int[] third;
		int[] fourth;
		
		public Tetromino() {
			// TODO Auto-generated constructor stub
		}
		
		public Tetromino(int[] first, int[] second, int[] third, int[] fourth) {
			this.first = first;
			this.second = second;
			this.third = third;
			this.fourth = fourth;
		}

		@Override
		public String toString() {
			return "Tetromino [first=" + Arrays.toString(first) + ", second=" + Arrays.toString(second) + ", third="
					+ Arrays.toString(third) + ", fourth=" + Arrays.toString(fourth) + "]";
		}

	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static int[][] map;
	
	public static void init() {
		map = new int[N][M];
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		init();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Tetromino tetro1 = new Tetromino();
		Tetromino tetro2 = new Tetromino();
		Tetromino tetro3 = new Tetromino();
		Tetromino tetro4 = new Tetromino();
		
		
	} // end of main
} // end of class
