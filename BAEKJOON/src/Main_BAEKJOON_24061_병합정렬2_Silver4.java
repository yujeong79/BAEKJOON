import java.io.*;
import java.util.*;

public class Main_BAEKJOON_24061_병합정렬2_Silver4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N; // 배열의 크기
	static int K; // 변경 횟수
	
	static int[] nums;
	static int[] tmp;
	
	static int cnt;
	static boolean answer = false;
	
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
		
		mergeSort(0, N-1);
		
		if(!answer) System.out.println(-1);
		
		
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
				tmp[idx++] = nums[L++];
				if(++cnt == K) {
					printArr(tmp);
					answer = true;
					break;
				}
			} else {
				tmp[idx++] = nums[R++];
				if(++cnt == K) {
					printArr(tmp);
					answer = true;
					break;
				}
			}
		}
		
		if(cnt < K && L <= mid) {
			for(int i = L; i <= mid; i++) {
				tmp[idx++] = nums[i];
				if(++cnt == K) {
					printArr(tmp);
					answer = true;
					break;
				}
			}
		} else if(cnt < K && R <= right) {
			for(int i = R; i <= right; i++) {
				tmp[idx++] = nums[i];
				if(++cnt == K) {
					printArr(tmp);
					answer = true;
					break;
				}
			}
		}
	}
	
	static void printArr(int[] arr) {
		for(int n : arr) {
			sb.append(n).append(" ");
		}
		System.out.println(sb);
	}
} // end of class
