import java.io.*;
import java.util.*;

/**
 * 10,000,000나노미터 = 1센티미터
 */
public class Main_3649_로봇프로젝트 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static final int nanometer = 10_000_000;
	static int x, n, maxDiff;
	static int[] lego;
	public static void main(String[] args) throws IOException {
		x = Integer.parseInt(br.readLine()); // 구멍의 너비 (1 ≤ x ≤ 20)
		n = Integer.parseInt(br.readLine()); // 레조 조각의 수 (0 ≤ n ≤ 1000000)
		
		lego = new int[n];
		for(int i = 0; i < n; i++) {
			lego[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(lego);
		maxDiff = 0;
		
		int L = 0;
		int R = n-1;
		while(L <= R) {
			int sum = lego[L]+lego[R];
			
			if(sum/nanometer == x && sum%nanometer == 0) {
				maxDiff = Math.max(maxDiff, Math.abs(lego[L]-lego[R]));
				L++;
				R--;
			} else {
				
			}
		}
		
	} // end of main
} // end of class
