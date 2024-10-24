import java.io.*;
import java.util.*;

/**
 * 세 수를 조합으로 찾아서 합을 구한 뒤, 해당 숫자가 집합에 있는지 이분탐색으로 찾는다.
 */

public class Main_2295_세수의합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, max, answer; 
	static int[] nums, result; // N개의 자연수로 이루어진 집합
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // (5 ≤ N ≤ 1,000)
		
		nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		max = nums[N-1];
		
		answer = 0;
		isSelected = new boolean[N];
		result = new int[3];
		comb(0, 0, 0);
		
		System.out.println(answer);
		
	} // end of main

	private static void comb(int cnt, int idx, int sum) {
		if(cnt >= 3) {
			System.out.println(Arrays.toString(result));
			binarySearch(sum);
			return;
		}
		
		if(sum > max) {
			return;
		}
		
		for(int i = idx; i < N; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				result[cnt] = nums[i];
				
				comb(cnt+1, idx+1, sum+nums[i]);
				
				isSelected[i] = false;
			}
		}
		
	}

	private static void binarySearch(int sum) {
//		System.out.println(sum);
//		int start = 0;
//		int end = N-1;
//		
//		while(start <= end) {
//			int mid = (start+end)/2;
//			
//			if(nums[mid] == sum) {
//				answer = Math.max(answer, sum);
//				return;
//			}
//			else if(nums[mid] > sum) start = mid;
//			else if(nums[mid] < sum) end = mid;
//		}
		
	}
} // end of class
