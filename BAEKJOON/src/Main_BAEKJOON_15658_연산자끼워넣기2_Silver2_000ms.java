import java.io.*;
import java.util.*;

public class Main_BAEKJOON_15658_연산자끼워넣기2_Silver2_000ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] nums;
	static int[] operator;
	
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // N개의 수
		
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		operator = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		backTracking(nums[0], 1);
		
		System.out.println(max + "\n" + min);
	}

	private static void backTracking(int result, int idx) {
		if(idx >= N) { // 기저 조건, 모든 피연산자를 다 계산하였을경우
			max = Math.max(result, max);
			min = Math.min(result, min);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(operator[i] > 0) {
				operator[i]--; // 해당 연산자를 사용하고
				switch(i) {
				case(0): // +
					backTracking(result + nums[idx], idx+1); // 하고 나왔으면 다음 경우의 수를 위해 
					operator[i]++; // 이전 상태로 되돌리기
					break;
				case(1): // -
					backTracking(result - nums[idx], idx+1);
					operator[i]++;
					break;
				case(2): // *
					backTracking(result * nums[idx], idx+1);
					operator[i]++;
					break;
				case(3): // /
					int ans = result < 0 ? result*-1 / nums[idx] * -1 : result / nums[idx];
					backTracking(ans, idx+1);
					operator[i]++;
					break;
				}
			}
			
			// 해당 연산자를 모두 사용하면 다음 연산자 확인
		}
		
		// 모든 연산자를 다 확인하였거나 다 사용할 수 없으면
		return;
		
	}
}
