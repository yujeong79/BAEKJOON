import java.io.*;
import java.util.*;

public class Main_7490_0만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static char[] result;
	
	public static void init() {
		result = new char[N-1];
	}
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {			
			N = Integer.parseInt(br.readLine());
			
			init();
			
			perm(0);
			
		} // end of testCase
		
	} // end of main
	
	static final char[] operators = {'+', '-', ' '};
	
	private static void perm(int cnt) {
		if(cnt == N-1) {
			calculation();
			return;
		}

		for(int i = 0; i < 3; i++) {
			result[cnt] = operators[i];
			perm(cnt+1);
		}
	}

	private static void calculation() {
		Queue<Character> queue = new LinkedList<>();

		int num = 1;
		int o = 0;
		
		while(num <= N) {
			queue.add((char)(num+'0'));
			
			if(num < N)
				queue.add(result[o]);
			
			num++;
			o++;
		}
		
		String str = "";
		int L = queue.poll() - '0';
		
	}

} // end of class