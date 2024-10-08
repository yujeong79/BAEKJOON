import java.io.*;
import java.util.*;

/**
 * 재귀로 풀어야할듯...
 */

public class Main_17609_회문 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			String str = br.readLine();
			
			int s = 0;
			int e = str.length()-1;
			
			int answer = 0;
			while(s <= e) {
				System.out.println(s + " " + e);
				
				if(str.charAt(s) == str.charAt(e)) { // 현재까지 회문이면 계속 진행
					s++; e--;
				}
				
				else if(answer == 0) { // 회문은 아니지만 아직 한 문자도 삭제를 안했다면 유사회문인지 확인					
					answer = 2; // 일단 회문이 아니라고 해두고
					
					if(str.charAt(s) == str.charAt(e-1)) { // 유사회문이 맞으면 answer = 1이 되도록 
						if(s == e-1 || str.charAt(s+1) == str.charAt(e-2)) {
							s++; e -= 2;
							answer = 1;
						}
					}
					
					if(answer == 2 && str.charAt(s+1) == str.charAt(e)) { // answer == 2면 위의 if문에 걸리지 않았다는 것이므로
						if(s+1 == e || str.charAt(s+2) == str.charAt(e-1)) {
							s += 2; e--;
							answer = 1;							
						}
					}
				}
				
				else { // 이미 한 문자를 삭제했다면 유사회문도 아니므로 종료
					answer = 2;
					break;
				}
			}
			
			sb.append(answer + "\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main
} // end of class
