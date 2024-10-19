import java.io.*;
import java.util.*;

public class Main_7490_0만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	//static List<String> answerList;
	static int N;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {			
			N = Integer.parseInt(br.readLine());
			
			backTracking(1, 1, "1", 0, 1);
			
			sb.append("\n");
			
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void backTracking(int idx, int left, String expression, int result, int op) {
		if(idx >= N) {
			result += (left*op);
			if(result == 0) {
				sb.append(expression + "\n");
			}
			return;
		}
		
		// ' ' 연산
		backTracking(idx+1, left*10+(idx+1), expression+" "+Integer.toString(idx+1), result, op);
		
		// + 연산
		backTracking(idx+1, idx+1, expression+"+"+Integer.toString(idx+1), result+(left*op), 1);
		
		// - 연산
		backTracking(idx+1, idx+1, expression+"-"+Integer.toString(idx+1), result+(left*op), -1);
		
	}


} // end of class