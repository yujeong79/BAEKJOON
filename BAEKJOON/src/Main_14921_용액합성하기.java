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
		
		answer = 200000000;
		
		int L = 0;
		int R = N-1;
		while(L < R) {
			int sum = Math.abs(solutions[L] + solutions[R]);
			if(sum < answer) {
				answer = sum;
			}
			
			if(sum >= answer) {
				R--;
			} else {
				L++;
			}
		}
	} // end of main
} // end of class
