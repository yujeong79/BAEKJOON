import java.io.*;
import java.util.*;

/**
 * [n-1]이 true(수)이고 [n-2]가 false(0)라면 true/false 둘 다 가능
 * [n-1]이 false -> [n]은 무조건 true
 * [n-2][n-2]가 둘 다 true -> [n]은 무조건 false
 */
public class Main_2579_계단오르기 {
	static class stair {
		int score;
		boolean[] isVisited;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] stairs;
	static List<int[]>[] dp;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 계단의 수
		
		stairs = new int[N+1];
		for(int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		
		
	} // end of main
} // end of class
