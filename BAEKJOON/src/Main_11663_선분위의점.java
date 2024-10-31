import java.io.*;
import java.util.*;

public class Main_11663_선분위의점 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[] points;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		points = new int[N+1];
		points[N] = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			points[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(points);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			binarySearch(start, end);
		}
		
		System.out.println(sb);
		
	} // end of main

	private static void binarySearch(int start, int end) {
		int lower = 0;
		int higher = N;
		
		// 해당 선분의 왼쪽 끝의 좌표의 인덱스를 구해보자
		while(lower < higher) {
			int mid = (lower + higher)/2;
			
			if(points[mid] >= start) higher = mid;
			else lower = mid + 1;
		}
		
		int lowerIdx = lower;
		
		lower = 0;
		higher = N;
		// 해당 선분의 오른쪽 끝의 좌표의 인덱스를 구해보자
		while(lower < higher) {
			int mid = (lower + higher)/2;
			
			if(points[mid] > end) higher = mid;
			else lower = mid + 1;
		}
		
		int higherIdx = higher;
		
		sb.append(higherIdx - lowerIdx + "\n");
	}
	
} // end of class
