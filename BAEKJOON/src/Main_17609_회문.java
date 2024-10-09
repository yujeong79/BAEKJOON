import java.io.*;
import java.util.*;

/**
 * 재귀
 */

public class Main_17609_회문 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int answer;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			String str = br.readLine();

			answer = 0;
			if(Palindrome(str)) {
				sb.append(answer + "\n");
			} else {
				sb.append("2 \n");
			}

		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static boolean Palindrome(String str) {
		int L = 0;
		int R = str.length()-1;

		while(L <= R) {
			if(str.charAt(L) == str.charAt(R)) {
				L++;
				R--;
			} else if(answer == 0) { // 아직 한 문자를 삭제하지 않았다면
				answer = 2;
				String leftCharRemove = str.substring(L+1, R+1);
				if(Palindrome(leftCharRemove)) { // 왼쪽 문자 삭제하고 다시 펠린드롬
					answer = 1;
					return true;
				}

				String rightCharRemove = str.substring(L, R);
				if(Palindrome(rightCharRemove)) { // 오른쪽 문자 삭제하고 다시 펠린드롬
					answer = 1;
					return true;
				}
				return false;
			} else {
				return false;
			}
		}

		return true;
	}

} // end of class
