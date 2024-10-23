import java.io.*;
import java.util.*;

public class Main_10816_숫자카드2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[] cards;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드의 개수
		cards = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cards);
		
		M = Integer.parseInt(br.readLine());
		
		/** M개의 숫자를 입력 받음과 동시에 해당 숫자 카드가 몇 개가 있는지 동시에 세자! */
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			count(Integer.parseInt(st.nextToken()));
		}
		
		System.out.println(sb);
		
	} // end of main

	private static void count(int num) {
		int start = 0;
		int end = N-1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(cards[mid] == num){
				int L = mid-1;
				int cnt = 0;
				
				while(L >= 0 && cards[L] == num) L--; // num과 같은 숫자 중 가장 왼쪽의 위치를 찾아서
				
				while(++L < N && cards[L] == num) {
					cnt++;
				}
				
				sb.append(cnt + " ");
				return;
			}
			
			else if(cards[mid] > num) {
				end = mid - 1;
			}
			
			else if(cards[mid] < num) {
				start = mid + 1;
			}
		}
		
		sb.append("0 ");
		
	}
	
} // end of class
