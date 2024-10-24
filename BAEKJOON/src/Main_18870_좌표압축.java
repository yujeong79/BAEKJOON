import java.io.*;
import java.util.*;

public class Main_18870_좌표압축 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int[] nums;
	static int[] orderedNums;
	static List<Integer> uniqueNums = new ArrayList<>();
	static int N, sSize;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		orderedNums = new int[N]; // 중복을 제거하기 이전 오름차순으로 정렬할 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			orderedNums[i] = nums[i];
		}
		
		Arrays.sort(orderedNums);
		int uniCnt = -1; // uniqueNums의 마지막 인덱스
		
		for(int i = 0; i < N; i++) {
			if(i == 0 || uniqueNums.get(uniCnt) != orderedNums[i]) {
				
				uniqueNums.add(orderedNums[i]);
				uniCnt++;
			}
		}
		
		for(int n : nums) {
			findIdx(n);
		}
		
		System.out.println(sb);
		
	} // end of main

	private static void findIdx(int n) {
		int start = 0;
		int end = uniqueNums.size();
		
		while(start < end) {
			int mid = (start+end)/2;
			
			if(uniqueNums.get(mid) < n) start = mid+1;
			else end = mid;
		}
		
		sb.append(start + " ");
		
	}
	
} // end of class
