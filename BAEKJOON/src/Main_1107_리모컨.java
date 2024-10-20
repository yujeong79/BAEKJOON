import java.io.*;
import java.util.*;

/**
 * 수빈이가 현재 보고 있는 채널은 100번
 */

public class Main_1107_리모컨 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] N;
	static int M, curr, minCnt;
	static boolean[] buttons = new boolean[10];
	
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		int nSize = str.length();
		
		N = new int[nSize];
		
		for(int i = 0; i < nSize; i++) {
			N[i] = str.charAt(i)-'0';
		}
		
		M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수
		
		Arrays.fill(buttons, true);
		
		if(M > 0) {
			String brokenButtons = br.readLine();
			for(int i = 0; i < M; i++) {
				int idx = brokenButtons.charAt(i*2)-'0';
				buttons[idx] = false;
			}
		}
		
		// 사용할 수 있는 버튼을 사용해서 최대한 N과 가까운 숫자를 만들어보자.
		
		
		
	} // end of main
} // end of class
