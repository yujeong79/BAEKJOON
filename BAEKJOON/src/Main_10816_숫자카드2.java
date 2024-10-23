import java.io.*;
import java.util.*;

/**
 * -10 -10 2 3 3 3 7 10 10 10
 *  
 */

public class Main_10816_숫자카드2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[] cards;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드의 개수
		cards = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cards);
		
		M = Integer.parseInt(br.readLine());
		nums = new int[M];
		
		/** M개의 숫자를 입력 받음과 동시에 해당 숫자 카드가 몇 개가 있는지 동시에 세자! */
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			count(nums[i]);
		}
		
		System.out.println(sb);
		
	} // end of main

	private static void count(int num) {
		int start = 0;
		int end = N-1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(cards[mid] > num) {
				end = mid - 1;
			}
			
			else if(cards[mid] < num) {
				start = mid + 1;
			}
			
			else if(cards[mid] == num){
				int L = mid;
				int R = mid;
				
				while(L >= 0 && cards[L] == num) L--;
				while(R < N && cards[R] == num) R++;
				
				sb.append((R-L-1) + " ");
				return;
			}
		}
		
		sb.append("0 ");
		
	}
	
} // end of class
