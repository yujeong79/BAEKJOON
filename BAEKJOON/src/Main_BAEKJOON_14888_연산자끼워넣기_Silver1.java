import java.io.*;
import java.util.*;

public class Main_BAEKJOON_14888_연산자끼워넣기_Silver1 {
	private static int N;
	private static char[] result;
	private static boolean[] isSelected;
	private static char[] operator;
	private static int[] nums;
	private static int min = Integer.MAX_VALUE;
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] count = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		operator = new char[N-1];
		for(int i = 0; i < count[0]; i++) { // 더하기 연산자 넣기
			operator[idx] = '+';
			idx++;
		}
		
		for(int i = 0; i < count[1]; i++) { // 빼기 연산자 넣기
			operator[idx] = '-';
			idx++;
		}
		
		for(int i = 0; i < count[2]; i++) { // 곱셈 연산자 넣기
			operator[idx] = '*';
			idx++;
		}
		
		for(int i = 0; i < count[3]; i++) { // 나누기 연산자 넣기
			operator[idx] = '/';
			idx++;
		}
		
		isSelected = new boolean[N-1];
		result = new char[N-1];
		perm(0);
		
		System.out.println(max +"\n" +min);
	} // end of main
	
	private static void perm(int cnt) {
		if(cnt == N-1) {
			calculation();
			return;
		}
		
		for(int i = 0; i < N-1; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				result[cnt] = operator[i];
				perm(cnt+1);
				isSelected[i] = false;
			}
		}
	}

	private static void calculation() {
		int[] temp = new int[N];
		for(int i = 0; i < N; i++) {
			temp[i] = nums[i];
		}
		
		for(int i = 0; i < N-1; i++) {
			int num1 = temp[i];
			int num2 = temp[i+1];
			char op = result[i];
			
			switch(op) {
			case('+'):
				temp[i+1] = num1 + num2;
				break;
			case('-'):
				temp[i+1] = num1 - num2;
				break;
			case('*'):
				temp[i+1] = num1 * num2;
				break;
			case('/'):
				temp[i+1] = num1 < 0 ? ((num1*-1) / num2) * - 1 : num1 / num2;
				break;
			}
		}
		
		max = Math.max(max, temp[N-1]);
		min = Math.min(min, temp[N-1]);
	}
	
} // end of class
