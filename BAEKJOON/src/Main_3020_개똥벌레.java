import java.io.*;
import java.util.*;

public class Main_3020_개똥벌레 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, H, halfN;
	static int[] up, down, row;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 동굴의 길이, (2 ≤ N ≤ 200,000)
		H = Integer.parseInt(st.nextToken()); // 동굴의 높이, (2 ≤ H ≤ 500,000)

		halfN = N/2;

		up = new int[halfN]; // 석순
		down = new int[halfN]; // 종유석
		row = new int[H];

		for(int i = 0; i < halfN; i++) {
			up[i] = Integer.parseInt(br.readLine());
			down[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(up);
		Arrays.sort(down);

		int min = N;
		int cnt = 0;
		for(int h = 1; h <= H; h++) {
			int upCnt = binarySearch(h); // 현재 구간에서 파괴해야하는 석순의 개수
			int downCnt = findDownCount(H-h+1); // 현재 구간에서 파괴해야 하는 종유석의 개수

			System.out.println(h + "구간에서 파괴해야하는 석순의 수 : " + upCnt + ", 종유석의 수 : " + downCnt);

			int total = upCnt + downCnt;
			if(total == min) { // 파괴해야하는 장애물의 수가 최소이면
				cnt++;
			} else if(total < min){
				cnt = 1;
				min = upCnt + downCnt;
			}
		}

		System.out.println(min + " " + cnt);

	} // end of main

	public static int binarySearch(int h) {
		int start = 0;
		int end = halfN-1;

		while(start <= end) {
			int mid = (start + end) / 2;
			if(up[mid] < h) end = mid - 1;
			else start = mid + 1;
		}
		int upper = start;

		// 1 3 5
		start = 0;
		end = halfN - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(up[mid] > h) start = mid + 1;
			else end = mid - 1;
		}
		int lower = start;

		return upper - lower;
	}

	public static int findDownCount(int h) {
		int start = 0;
		int end = halfN-1;

		while(start <= end) {
			int mid = (start + end) / 2;
			if(down[mid] < h) end = mid - 1;
			else start = mid + 1;
		}

		return start;
	}

} // end of class
