import java.io.*;
import java.util.*;

/**
 * 밖에서 부터 0을 탐색하기!!
 */
public class Main_BAEKJOON_2636_치즈_Gold4_000ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static final int[] dr = {-1, 0, 1, 0};
	static final int[] dc = {0, 1, 0, -1};
	
	static int N, M;
	static char[][] cheese;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 세로 길이
		M = Integer.parseInt(st.nextToken()); // 가로 길이
		
		cheese = new char[N][M];
		for(int i = 0; i < N; i++) { // 치즈 입력 받기
			cheese[i] = br.readLine().toCharArray();
		}
		
		
		
		// 이걸 왜 BFS>..?
	}
}
