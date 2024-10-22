import java.io.*;
import java.util.*;


public class Main_17951_흩날리는시험지속에서내평점이느껴진거야 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, K, min, max, mid, answer;
	static int[] papers;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // (1 ≤ K ≤ N ≤ 105)
		N = Integer.parseInt(st.nextToken()); // 시험지의 개수 
		K = Integer.parseInt(st.nextToken()); // 시험지를 나눌 그룹의 수, (0 ≤ x ≤ 20)
		
		papers = new int[N];
		min = Integer.MAX_VALUE;
		max = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			papers[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, papers[i]); // 최솟값 설정
			max += papers[i];
		}
		
		while(min <= max) {
			mid = (min + max) / 2;
			if(possible()) {
				answer = mid;
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		
		System.out.println(answer);
		
	} // end of main

	private static boolean possible() {
		int count = 0;
		int currArrSum = 0;
		
		for(int p : papers) {
			currArrSum += p;
			if(currArrSum >= mid) {
				count++;
				currArrSum = 0;
			}
		}
		
		return count >= K;
	}
} // end of class
