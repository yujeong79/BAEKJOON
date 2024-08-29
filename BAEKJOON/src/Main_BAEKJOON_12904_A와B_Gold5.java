import java.io.*;
import java.util.*;

public class Main_BAEKJOON_12904_A와B_Gold5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int idx = 0;
	
	static List<Character> sList;
	
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		
		char[] S = new char[str.length()];
		for(int i = 0; i < str.length(); i++) {
			S[i] = str.charAt(i);
		}
		
		char[] T = br.readLine().toCharArray();
		
		// 이어붙이기
		for(int i = str.length(); i < T.length; i++) {
			S[i] = T[i];
		}
		
		


	} // end of main
} // end of class
