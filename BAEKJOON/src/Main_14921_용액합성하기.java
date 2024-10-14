import java.io.*;
import java.util.*;

public class Main_14921_용액합성하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, answer;
	static int[] solutions;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		solutions = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			solutions[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(solutions);
		
		answer = Integer.MAX_VALUE;
		
		int L = 0;
		int R = N-1;
		while(L < R) {
			int sum = solutions[L] + solutions[R];
			if(Math.abs(sum) < Math.abs(answer)) {
				answer = sum;
			}
			
			if(sum > 0) {
				R--;
			} else {
				L++;
			}
		}
		
		System.out.println(answer);
	} // end of main
} // end of class
