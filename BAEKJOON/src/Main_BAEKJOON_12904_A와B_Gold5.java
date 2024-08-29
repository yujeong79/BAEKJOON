import java.io.*;
import java.util.*;

public class Main_BAEKJOON_12904_A와B_Gold5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int idx = 0;
	
	static List<Character> sList;
	
	public static void main(String[] args) throws IOException {
		char[] S = br.readLine().toCharArray();
		
		char[] T = br.readLine().toCharArray();
		List<Character> tList = new ArrayList<>();
		for(int i = 0; i < T.length; i++) {
			tList.add(T[i]);
		}
		
		while(tList.size() > S.length) {
			int last = tList.size()-1;
			if(tList.get(last) == 'A') {
				tList.remove(last);
			} else {
				tList.remove(last);
				Collections.reverse(tList);
			}
		}
		
		int flag = 1;
		for(int i = 0; i < S.length; i++) {
			if(tList.get(i) != S[i]) {
				flag = 0;
				break;
			}
		}
		
		System.out.println(flag);
		
		
	} // end of main
} // end of class
