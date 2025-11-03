import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 2 <= N <= 100,000
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = Integer.MAX_VALUE;
		int num1 = nums[0];
		int num2 = nums[N-1];
		
		int left = 0;
		int right = N-1;
		while(right >= 0 && left < right) {
			int curr = nums[left] + nums[right];
			
			if(Math.abs(curr) <= sum) {
				sum = Math.abs(curr);
				num1 = nums[left];
				num2 = nums[right];
			}
			
			if(curr < 0) left++;
			else right--;
		}
		
		System.out.println(num1 + " " + num2);
	}
}