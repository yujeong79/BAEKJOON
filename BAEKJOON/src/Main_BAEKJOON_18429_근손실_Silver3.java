import java.io.*;
import java.util.*;

public class Main_BAEKJOON_18429_근손실_Silver3 {
	static int N, K;
	static int[] exercise;
	static int answer;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // N일 동안
		K = Integer.parseInt(st.nextToken()); // 하루당 중량이 K만큼 감소
		
		st = new StringTokenizer(br.readLine(), " ");
		exercise = new int[N];
		for(int i = 0; i < N; i++) {
			exercise[i] = Integer.parseInt(st.nextToken());
		}
		
		isSelected = new boolean[N];
		backTracking(1, 500);
		
		System.out.println(answer);
		
	} // end of main
	
	private static void backTracking(int day, int curr) {
		if(day >= N && curr >= 500) { // 기저 조건
			answer++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!isSelected[i] && curr + exercise[i] - K >= 500) {
				isSelected[i] = true;
				backTracking(day+1, curr + exercise[i] - K);
				isSelected[i] = false;
			}
		}
		
		// 모든 운동 키드가 다 안되거나 모든 운동키트를 다 탐색하였다면
		return;
		
	}
	
} // end of class
