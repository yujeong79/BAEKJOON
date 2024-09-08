import java.io.*;
import java.util.*;

public class Main_BAEKJOON_1182_부분수열의합_Silver2_188ms {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N;
	private static int S;
	private static int[] nums;
	private static boolean[] isSelected;
	private static int answer;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 정수의 개수
		S = Integer.parseInt(st.nextToken()); // 다 더한 값이 S가 되는 경우의 수

		nums = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		isSelected = new boolean[N];
		powerset(0);
		
		answer = S == 0 ? answer - 1: answer;
		System.out.println(answer);
	}

	private static void powerset(int idx) {
		if(idx == N) {
			int total = 0;
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) total += nums[i];
			}
			if(total == S) answer++;
			return;
		}
		
		isSelected[idx] = true;
		powerset(idx+1);
		
		isSelected[idx] = false;
		powerset(idx+1);
	}
}
