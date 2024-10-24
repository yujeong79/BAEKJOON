import java.io.*;
import java.util.*;

public class Main_18870_좌표압축 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int[] nums;
	static Set<Integer> set= new HashSet<>();
	static List<Integer> orderedNums;
	static int N, sSize;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			set.add(nums[i]);
		}
		
		sSize = set.size();
		orderedNums = new ArrayList<>(set);
		Collections.sort(orderedNums);		
		
		for(int n : nums) {
			findIdx(n);
		}
		
		System.out.println(sb);
		
	} // end of main

	private static void findIdx(int n) {
		int start = 0;
		int end = sSize-1;
		
		while(start < end) {
			int mid = (start+end)/2;
			
			if(orderedNums.get(mid) < n) start = mid+1;
			else end = mid;
		}
		
		sb.append(start + " ");
		
	}
	
} // end of class
