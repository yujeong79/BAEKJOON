import java.io.*;
import java.util.*;

public class Main_7490_0만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static char[] result;
	
	public static void init() {
		result = new char[N-1];
	}
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {			
			N = Integer.parseInt(br.readLine());
			
			init();
			
			perm(0);
			
			sb.append("\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main
	
	static final char[] operators = {'+', '-', ' '};
	
	private static void perm(int cnt) {
		if(cnt == N-1) {
			makeString();
			return;
		}

		for(int i = 0; i < 3; i++) {
			result[cnt] = operators[i];
			perm(cnt+1);
		}
	}

	private static void makeString() {
		String str = "";
		int num = 1;
		int oIdx = 0;
		
		while(num <= N) {
			str += num + "";
			
			if(num < N) {
				str += result[oIdx];
			}
			
			num++;
			oIdx++;
		}
		
		if(calculation(str) == 0) {
			sb.append(str+"\n");
		}
		
		return;
	}

	private static int calculation(String str) {
		Queue<String> queue = new LinkedList<>();
		
		int size = str.length();
		int i = 0;
		while(i < size) {
			if(i == size-1) {
				queue.add(str.charAt(i)+"");
				break;
			}
			
			String left = str.charAt(i)+"";
			char operator = str.charAt(i+1);
			if(operator == ' ') {
				left += str.charAt(i+2)+"";
				queue.add(left);
				i += 3;
				continue;
			} else {
				queue.add(left);
				queue.add(operator+"");
				
				i += 2;
			}
		}
		
		System.out.println(queue.toString());
		
		return 0;
	}

} // end of class