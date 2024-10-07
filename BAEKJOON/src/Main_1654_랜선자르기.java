import java.io.*;
import java.util.*;

public class Main_1654_랜선자르기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int K, N, maxK;
	static long answer;
	static int[] LAN;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수
		N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
		
		maxK = 0; // 가지고 있는 K개의 랜선 중 가장 긴 길이를 저장
		LAN = new int[K];
		for(int i = 0; i < K; i++) {
			LAN[i] = Integer.parseInt(br.readLine());
			maxK = Math.max(maxK, LAN[i]);
		}

		answer = 0;
		
		// 최대 랜선의 길이를 이분 탐색으로 찾아보자
		long L = 0;
		long R = maxK;
		long mid = (L+R+1)/2;
		while(L <= R && mid <= maxK && mid > 0) {
			long cnt = 0;
			
			for(int i = 0; i < K; i++) {
				cnt += LAN[i]/mid;
			}
			
			if(cnt >= N) { // 개수가 N개 이상이 되면
				L = mid+1;
				answer = Math.max(answer, mid);
			} else { // 개수가 N개 미만이면
				R = mid-1;
			}
			
			mid = (L+R+1)/2;
		}
		
		System.out.println(answer);
	} // end of main
} // end of class
