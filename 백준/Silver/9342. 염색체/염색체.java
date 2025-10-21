import java.util.*;
import java.io.*;

public class Main {
	static String sentence;
	static int N;
	static List<Character> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Character[] arr = {'A', 'B', 'C', 'D', 'E', 'F'};
		list = Arrays.asList(arr);
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			sentence = br.readLine();
			N = sentence.length();
			int i = 0;
			
			sb.append(start(i)).append("\n");
	
		} // end of test case
		
		System.out.println(sb);
	}
	
	public static String start(int i) {
		if(i >= N) return "Good";
		
		if(list.contains(sentence.charAt(i))) {
			if(sentence.charAt(i) == 'A') 
				return nextWithA(i);
			
			return nextWithA(i+1);
		}
		
		return "Good";
	}
	
	public static String nextWithA(int i) {
		if(i >= N || sentence.charAt(i) != 'A') 
			return "Good";
		
		while(i < N && sentence.charAt(i) == 'A') {
			i++;
		}
		
		return nextWithF(i);
	}
	
	public static String nextWithF(int i) {
		if(i >= N || sentence.charAt(i) != 'F') 
			return "Good";
		
		while(i < N && sentence.charAt(i) == 'F') {
			i++;
		}
		
		return nextWithC(i);
	}
	
	public static String nextWithC(int i) {
		if(i >= N || sentence.charAt(i) != 'C') 
			return "Good";
		
		while(i < N && sentence.charAt(i) == 'C') {
			i++;
		}
		
		return end(i);
	}
	
	public static String end(int i) {
		if(i >= N || list.contains(sentence.charAt(i)) && i == N-1) 
			return "Infected!";
		
		return "Good";
	}
}