import java.io.*;
import java.util.*;

public class Main_BAEKJOON_24060_병합정렬1_Silver3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N; // 배열의 크기
	static int K; // 저장 횟수
	
	static int[] nums; // 입력 받은 배열, 정렬 대상
	static int[] tmp; // 해당 구간 정렬을 위한 임시 배열
	
	static int cnt = 0;
	static int answer = -1;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		tmp = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		int i = 0;
		while(st.hasMoreTokens()) {
			nums[i++] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(0, N-1);
		
		System.out.println(answer);
		
	} // end of main
	
	static void mergeSort(int left, int right) {
		if(left >= right) return;
		
		int mid = (left+right)/2;
		mergeSort(left, mid);
		mergeSort(mid+1, right);
		merge(left, mid, right);
	}
	
	static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid+1;
		
		int idx = left;
		
		while(L <= mid && R <= right) {
			if(nums[L] <= nums[R]) {
				if(++cnt == K) answer = nums[L];
				tmp[idx++] = nums[L++];
			} else {
				if(++cnt == K) answer = nums[R];
				tmp[idx++] = nums[R++];
			}
		}
		
		if(L <= mid) {
			for(int i = L; i <= mid; i++) {
				if(++cnt == K) answer = nums[i];
				tmp[idx++] = nums[i];
			}
		} else {
			for(int i = R; i <= right; i++) {
				if(++cnt == K) answer = nums[i];
				tmp[idx++] = nums[i];
			}
		}
		
		for(int i = left; i <= right; i++) {
			nums[i] = tmp[i];
		}
	}
	
} // end of class
