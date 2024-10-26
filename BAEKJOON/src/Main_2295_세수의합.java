import java.io.*;
import java.util.*;

/**
 * nums의 두 수를 합친 temp 배열을 만들고 nums[i] - nums[j]가 temp 배열에 있는지 이분탐색
 */

public class Main_2295_세수의합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N; 
	static int[] nums, temp;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // (5 ≤ N ≤ 1,000)
		
		nums = new int[N];
		temp = new int[N*(N+1)/2];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		
		int idx = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i; j < N; j++) {
				temp[idx++] = nums[i]+nums[j];
			}
		}
		
		Arrays.sort(temp);
		
		boolean flag = false;
		
		for(int i = N-1; i > 0 && !flag; i--) {
			for(int j = 0; j < i && !flag; j++) {
				if(binarySearch(nums[i]-nums[j])) {
					flag = true;
					System.out.println(nums[i]);
				}
			}
		}
		
		
	} // end of main

	private static boolean binarySearch(int num) {
		int start = 0;
		int end = temp.length-1;
		
		while(start <= end) {
			int mid = (start+end)/2;
			
			if(temp[mid] == num) return true;
			else if(temp[mid] > num) end = mid - 1;
			else if(temp[mid] < num) start = mid + 1;
		}
		
		return false;
		
	}

} // end of class