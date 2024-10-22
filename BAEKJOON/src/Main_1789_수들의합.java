import java.io.*;
import java.util.*;

/**
 * 서로 다른 N개의 자연수의 합이 S 일 때 N의 최댓값 
 */

public class Main_1789_수들의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long S = Integer.parseInt(br.readLine());
		
		long start = 1;
		long end = S;
		
		long answer = 0;
		
		while(start <= end) {
			long mid = (start + end) / 2;
			
			long sum = (mid*(mid+1)) / 2; // 1부터 mid까지 수의 합
			
			if(sum > S) {
				end = mid + 1;
			}
			
			else {
				start = mid + 1;
				answer = mid;
			}
		}
		
		System.out.println(answer);
		
	} // end of main
} // end of class
