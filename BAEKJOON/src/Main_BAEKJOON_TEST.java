import java.io.*;
import java.util.*;

public class Main_BAEKJOON_TEST {
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int M;
	
	static int[] nums;
	static int[] result;
	
	static Set<String> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums); // 사전 순으로 증가하는 순서
		
		result = new int[M];
		set = new LinkedHashSet<>();
		
		comb(0, 0);
		
		for(String s : set) {
			st = new StringTokenizer(s, " ");
			while(st.hasMoreTokens())
				sb.append(st.nextToken()).append(" ");
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	} // end of main
	
	static void comb(int cnt, int start) {
		if(cnt == M) {
			String num = "";
			for(int n : result) num += n+" ";
			set.add(num);
			return;
		}
		
		for(int i = start; i < N; i++) {
			result[cnt] = nums[i];
			comb(cnt+1, i);
		}
	}
	
} // end of class
