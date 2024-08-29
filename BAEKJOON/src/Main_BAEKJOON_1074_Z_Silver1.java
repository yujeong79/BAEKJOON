import java.io.*;
import java.util.*;

public class Main_BAEKJOON_1074_Z_Silver1 {
	
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 2^N * 2^N 크기의 2차원 배열
		int r = Integer.parseInt(st.nextToken()); // r행
		int c = Integer.parseInt(st.nextToken()); // c열
		
		int size = (int)Math.pow(2, N);
		arr = new int[size][size];
		
		zfn(N, size-1, size-1);
		
		for(int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
		
	} // end of main
	static int num = 0;
	
	static void zfn(int N, int r, int c) {
		System.out.println("현재 r : " + r + ", c : " + c);
		// 기저 조건
		if(N <= 1) {
			arr[r-1][c-1] = num++;
			//System.out.println(arr[r-1][c-1]);
			arr[r-1][c] = num++;
			//System.out.println(arr[r-1][c]);
			arr[r][c-1] = num++;
			//System.out.println(arr[r][c-1]);
			arr[r][c] = num++;
			//System.out.println(arr[r][c]);
			return;
		}
		
		System.out.print(1);
		zfn(N-1, r/2, c/2);
		System.out.print(2);
		zfn(N-1, r/2, c);
		System.out.print(3);
		zfn(N-1, r, c/2);
		System.out.print(4);
		zfn(N-1, r, c);
	}
	
} // end of class
