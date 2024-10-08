import java.io.*;
import java.util.*;

public class Main_22871_징검다리건너기large {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] stones;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 돌의 개수
		
		stones = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			stones[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
	} // end of main
} // end of class
