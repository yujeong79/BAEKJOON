import java.io.*;
import java.util.*;

public class MAIN_BAEKJOON_24061_병합정렬2_Silver4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N; // 배열의 크기
	static int K; // 변경 횟수
	
	static int[] nums;
	static int[] tmp;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	
		nums = new int[N];
		tmp = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		
	} // end of main
} // end of class
