import java.io.*;
import java.util.*;

public class Main_1806_부분합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, S;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // N개의 수, (10 ≤ N < 100,000)
		S = Integer.parseInt(st.nextToken()); // 합이 S 이상, (0 < S ≤ 100,000,000)
		
		int answer = N+1;
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		nums[0] = Integer.parseInt(st.nextToken());
		for(int i = 1; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(n >= S) {
				answer = 1;
				break;
			}
			
			nums[i] = nums[i-1] + n;
		}
		
		System.out.println(Arrays.toString(nums));
		
		if(answer != 1 && nums[N-1] < S) answer = 0;
		else if(answer != 1){
			for(int i = 0; i < N; i++) {
				for(int j = i; j < N; j++) {
					if(nums[j] - nums[i] >= S) {
						answer = Math.min(answer, j-i);
					}
				}
			}
		}
		
		System.out.println(answer);
	} // end of main
} // end of class
