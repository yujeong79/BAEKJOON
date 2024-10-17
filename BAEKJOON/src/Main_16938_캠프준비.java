import java.io.*;
import java.util.*;

public class Main_16938_캠프준비 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, L, R, X, answer;
	static int[] levels;
	static boolean[] isSelected;
	
	public static void init() {
		levels = new int[N];
		isSelected = new boolean[N];
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // N개의 문제
		L = Integer.parseInt(st.nextToken()); // 문제 난이도의 최소 합
		R = Integer.parseInt(st.nextToken()); // 문제 난이도의 최대 합
		X = Integer.parseInt(st.nextToken()); // 가장 어려운 문제와 쉬운 문제의 난이도 차가 X보다 크거가 같아야 함
		
		init();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			levels[i] = Integer.parseInt(st.nextToken());
		}
		
		backTracking(0, 0, 0); 
		
		System.out.println(answer);
		
	} // end of main

	private static void backTracking(int idx, int sum, int cnt) {
		if(idx == N) {
			if(cnt < 2 || sum < L || sum > R) return; // 문제 난이도의 최소 합보다 적거나 문제가 2개 이상 뽑히지 않은 경우엔 종료
			
			int minLevel = Integer.MAX_VALUE;
			int maxLevel = 0;
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					minLevel = Math.min(minLevel, levels[i]);
					maxLevel = Math.max(maxLevel, levels[i]);
				}
			}
			
			if(maxLevel - minLevel >= X) {
				answer++;
			}
			
			return;
		}
		
		if(sum > R) {
			return;
		}
		
		isSelected[idx] = true;
		backTracking(idx+1, sum+levels[idx], cnt+1);
		
		isSelected[idx] = false;
		backTracking(idx+1, sum, cnt);
	}
	
} // end of class
