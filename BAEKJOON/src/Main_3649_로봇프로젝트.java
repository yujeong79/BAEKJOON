import java.io.*;
import java.util.*;

/**
 * 10,000,000나노미터 = 1센티미터
 */
public class Main_3649_로봇프로젝트 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int x, n;
	static int[] lego;
	
	public static void main(String[] args) throws IOException {
		String firstInput = null;
		while((firstInput=br.readLine()) != null) {
			x = Integer.parseInt(firstInput)*10000000; // 구멍의 너비 (1 ≤ x ≤ 20)
			n = Integer.parseInt(br.readLine()); // 레조 조각의 수 (0 ≤ n ≤ 1,000,000)
			
			lego = new int[n];
			for(int i = 0; i < n; i++) {
				lego[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(lego);
			
			boolean flag = false;
			
			int L = 0;
			int R = n-1;
			while(L < R) {
				int sum = lego[L]+lego[R];
				
				if(sum == x) { // 두 조각이 구멍의 너비 x를 완벽하게 막으면
					System.out.println("yes " + lego[L] + " " + lego[R]);
					flag = true;
					break;
				} else { // 막지 못하는 경우
					if(sum > x) { //  두 조각의 합이 구멍의 너비보다 큰 경우
						R--;
					} else { // 두 조각의 합이 구멍의 너비보다 작은 경우
						L++;
					}
				}
			}
			
			if(!flag) System.out.println("danger");
			
			firstInput = null;
		} // end of testCase
	} // end of main
} // end of class
