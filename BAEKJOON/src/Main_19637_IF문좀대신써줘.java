import java.io.*;
import java.util.*;

/**
 * 범위만 기억할까 아니면 배열을 만들까
 * 이렇게 생각하면 범위만 기억하는게 훨씬 낫긴 낫겠다.
 * 
 * 위의 방법처럼 하니까 시간초과가 나네...
 */

public class Main_19637_IF문좀대신써줘 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, vSize;
	static int[] character;
	static String[] key;
	static int[] value;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 칭호의 개수
		M = Integer.parseInt(st.nextToken()); // 캐릭터의 개수
		
		key = new String[N];
		value = new int[N];
		
		int former = 0; // 이전의 power를 저장
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String k = st.nextToken();
			int v = Integer.parseInt(st.nextToken());
			
			key[i] = k;
			value[i] = v;
				
		}
		
		character = new int[M+1];
		for(int i = 0; i < M; i++) {
			character[i] = Integer.parseInt(br.readLine());
			
			binarySearch(character[i]);
		}
		
		System.out.println(sb);
		
	} // end of main

	/**
	 * 현재 캐릭터의 칭호를 찾는 메서드
	 * @param curr : 현재 캐릭터
	 */
	private static void binarySearch(int curr) {
		int start = 0;
		int end = N - 1;
		
		int result = 0;
		
		while(start <= end) {
			int mid = (start+end)/2;
				
			if(value[mid] >= curr) {
				end = mid - 1;
				result = mid;
			}
			
			else if(value[mid] < curr) {
				start = mid + 1;
			}
		}
		
		sb.append(key[start] + "\n");

	}
	
} // end of class
