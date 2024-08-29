import java.io.*;
import java.util.*;

public class Main_BAEKJOON_12904_A와B_Gold5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int idx = 0;
	
	static List<Character> sList;
	
	public static void main(String[] args) throws IOException {
<<<<<<< HEAD
		String str = br.readLine();
		
		char[] S = new char[str.length()];
		for(int i = 0; i < str.length(); i++) {
			S[i] = str.charAt(i);
		}
=======
		char[] S = br.readLine().toCharArray();
>>>>>>> branch 'main' of https://github.com/yujeong79/BAEKJOON.git
		
		char[] T = br.readLine().toCharArray();
		List<Character> tList = new ArrayList<>();
		for(int i = 0; i < T.length; i++) {
			tList.add(T[i]);
		}
		
<<<<<<< HEAD
		// 이어붙이기
		for(int i = str.length(); i < T.length; i++) {
			S[i] = T[i];
=======
		while(tList.size() > S.length) {
			int last = tList.size()-1;
			if(tList.get(last) == 'A') {
				tList.remove(last);
			} else {
				tList.remove(last);
				Collections.reverse(tList);
			}
>>>>>>> branch 'main' of https://github.com/yujeong79/BAEKJOON.git
		}
		
<<<<<<< HEAD
=======
		int flag = 1;
		for(int i = 0; i < S.length; i++) {
			if(tList.get(i) != S[i]) {
				flag = 0;
				break;
			}
		}
>>>>>>> branch 'main' of https://github.com/yujeong79/BAEKJOON.git
		
<<<<<<< HEAD


=======
		System.out.println(flag);
		
		
>>>>>>> branch 'main' of https://github.com/yujeong79/BAEKJOON.git
	} // end of main
} // end of class
