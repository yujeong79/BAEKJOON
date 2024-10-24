import java.io.*;
import java.util.*;

public class Main_10816_숫자카드2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[] cards;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드의 개수
		cards = new int[N+1]; 
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		cards[N] = Integer.MAX_VALUE;
		
		Arrays.sort(cards);
		
		M = Integer.parseInt(br.readLine());
		
		/** M개의 숫자를 입력 받음과 동시에 해당 숫자 카드가 몇 개가 있는지 동시에 세자! */
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			findIdx(Integer.parseInt(st.nextToken()));
		}
		
		System.out.println(sb);
		
	} // end of main

	// 해당 숫자의 가장 왼쪽 인덱스와 가장 오른쪽 인덱스를 찾자
	private static void findIdx(int num) {
		int start = 0;
		int end = N;
		int mid = 0;
		
		int leftIdx = 0;
		while(start < end) {
			mid = (start+end)/2;
			
			/** num과 같은 경우에 start를 올려주게 되면 안되니까!!
			 *  가장 왼쪽 인덱스는 해당 배열에서 처음으로 num값이 나오는 자리에 들어가야하므로
			 *  end를 num과 같은 경우 mid를 가리키게 한다.
			 */
			if(cards[mid] >= num) end = mid;
			else start = mid + 1;
		}
		
		leftIdx = start;
		
		start = 0;
		end = N;
		
		int rightIdx = N;
		while(start < end) {
			mid = (start+end)/2;
			
			if(cards[mid] <= num) start = mid + 1;
			else end = mid;
		}
		
		rightIdx = end;
		
		sb.append((rightIdx-leftIdx) + " ");
		
	}
	
} // end of class
