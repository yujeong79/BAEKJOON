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
			
			//answerList = new ArrayList<>();
			
			backTracking(1, 2, "1", 1, "");
			
			//Collections.sort(answerList);
			
//			for(String str : answerList) {
//				sb.append(str);
//			}
			
			sb.append("\n");
			
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void backTracking(int left, int right, String str, int result, String op) {
		if(right > N) {
			if(result == 0) {
				sb.append(str + "\n");
			}
			return;
		}
		
		// ' ' 연산
		switch(op) {
		case "+":
			backTracking(left+1, right+1, str+" "+right, result-left+(left*10+right), "+");
			break;
		case "-":
			backTracking(left+1, right+1, str+" "+right, result+left-(left*10+right), "-");
			break;
		}
		
		// + 연산
		backTracking(left+1, right+1, str+"+"+right, result+right, "+");
		
		// - 연산
		backTracking(left+1, right+1, str+"-"+right, result-right, "-");
		
	}


} // end of class