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
			int upCnt = halfN-binarySearch(up, h); // 현재 구간에서 파괴해야하는 석순의 개수
			int downCnt = halfN-binarySearch(down, H-h+1); // 현재 구간에서 파괴해야 하는 종유석의 개수

			int total = upCnt + downCnt;
			if(total == min) { // 파괴해야하는 장애물의 수가 최소이면
				cnt++;
			} else if(total < min){
				cnt = 1;
				min = upCnt + downCnt;
			}
		}

		System.out.println(min + " " + cnt); // ddd

	} // end of main

	public static int binarySearch(int[] arr, int h) {
		int start = 0;
		int end = halfN;

		// lower 구하기
		while(start < end) {
			int mid = (start + end) / 2;

			if (arr[mid] < h) start = mid + 1;
			else end = mid;
		}

		return start;
	}

} // end of class
