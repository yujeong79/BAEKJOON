import java.io.*;
import java.util.*;

/**
 * 정해진 총액 이하에서 가능한 최대의 총 예산을 배정
 * 	1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정
 *  2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예상요청에는 모두 상한액을 배정한다.
 *     상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정
 */

public class Main_2512_예산 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, start, end, answer;
	static int[] budget;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 예산을 요청하는 지방의 수
		
		start = end = 0;
		
		budget = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, budget[i]); // 요청하는 예산 중 최댓값을 end로 지정
		}
		
		M = Integer.parseInt(br.readLine()); // 총 예산
		
		binarySearch();
		
		System.out.println(answer);
		
	} // end of main
	
	private static void binarySearch() {
		
		while(start <= end) { // start와 end가 만나는 지점이 가능한 최대의 예산
			int mid = (start + end)/2;
			
			if(isPossible(mid)) { // mid값으로 예산을 배정하는 경우, 총 예산 이내라면
				start = mid + 1;
				answer = mid;
			} else { // mid값으로 예산을 배정하는 경우, 총 예산을 벗어나게 된다면
				end = mid - 1;
			}
		}
	}

	private static boolean isPossible(int mid) {
		int total = 0;
		
		for(int b :budget) {
			if(b >= mid) total += mid;
			else total += b;
			
			if(total > M) return false;
		}
		
		return true;
	}
	
} // end of class
