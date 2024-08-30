import java.io.*;
import java.util.*;

/**
 * N*N의 map을 만들고 파이프가 있으면 1, 없으면 0이다.
 * isPromising
 * 	가로인 경우 : 파이프를 옮겼을 때 벽에 부딪히지 않거나 끝에 닿지 않으면 true
 * 		가로 먼저 해보고 다 갔다가 다시 백해서 돌아올 때 대각선 해보기?
 * 	세로인 경우 : 파이프를 옮겼을 때 벽에 부딪히지 않거나 끝에 닿지 않으면 true
 * 		세로 먼저 해보고 다 갔다가 다시 백해서 돌아올 때 대각선 해보기?
 *  대각선인 경우 :  파이프를 옮겼을 때 벽에 부딪히지 않으면 true
 * 		가로 먼저 해보고 다 갔다가 다시 백해서 돌아올 때 세로 해보고 대각선 해보기?
 */

public class Main_BAEKJOON_17070_파이프옮기기1_Gold5 {	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int N; // N*N 맵

	private static char[][] map;
	
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			String row = br.readLine();
			for(int j = 0, c = 0; j < N; j++, c+=2) {
				map[i][j] = row.charAt(c);
			}
		}
		
		map[0][0] = '-'; map[0][1] = '-';
		
		for(char[] r : map) {
			System.out.println(Arrays.toString(r));
		}
		
	} // end of main
} // end of class
