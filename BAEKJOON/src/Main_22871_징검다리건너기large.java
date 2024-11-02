import java.io.*;
import java.util.*;

public class Main_22871_징검다리건너기large {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static long min, max, answer;
	static int[] stones;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 돌의 개수

		stones = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			stones[i] = Integer.parseInt(st.nextToken());
		}

		min = 1;
		max = (long) (N-1)*(Math.abs(stones[0]-stones[N-1])+1);

		binarySearch(min, max);

		System.out.println(answer);
	} // end of main

	private static void binarySearch(long start, long end) {
		while(start <= end) {
			long mid = (start + end)/2;

			// 모든 경우 중 가능한 K의 최솟값
			if(isPossible(mid)) {
				answer = mid;
				end = mid - 1;
			} else { // mid가 불가능하다면
				start = mid + 1;
			}
		}
	}

	private static boolean isPossible(long power) {
		Stack<Integer> stack = new Stack<>();
		boolean[] isVisited = new boolean[N];

		stack.push(0); // 맨 첫 인덱스 넣기
		isVisited[0] = true;

		while(!stack.empty()) {
			int curr = stack.pop();

			for(int next = curr+1; next < N; next++) {
				long result = (long) (next-curr) * (Math.abs(stones[curr]-stones[next])+1);
				if(result <= power && !isVisited[next]) {
					if(next == N-1) return true;
					stack.push(next);
					isVisited[next] = true;
				}
			}
		}

		return false;
	}

} // end of class
