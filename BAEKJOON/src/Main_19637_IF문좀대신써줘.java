import java.io.*;
import java.util.*;

public class Main_19637_IF문좀대신써줘 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static Map<String, Integer> map;
	static int N, M;
	static int[] character;
	static String[] titles;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 칭호의 개수
		M = Integer.parseInt(st.nextToken()); // 캐릭터의 개수
		
		map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String title = st.nextToken();
			int power = Integer.parseInt(st.nextToken());
			
			map.put(title, power);
		}
		
		character = new int[M];
		for(int i = 0; i < M; i++) {
			character[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(character);
		
		for(String key : map.keySet()) {
			binarySearch(map.get(key));
		}
		
		
	} // end of main

	private static void binarySearch(Integer power) {
		int start = 0;
		int end = M-1;
		
		while(start <= end) {
			int mid = (start+end)/2;
			
			if(character[mid] > power) end = mid - 1;
		}
		
	}
	
} // end of class
