import java.io.*;
import java.util.*;

public class Main_2470_두용액 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, s1, s2, minSum;
	static int[] solutions; 
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 전체 용액의 수, 2 이상 100,000 이하
		
		solutions = new int[N];		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			solutions[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(solutions);
		
		minSum = Integer.MAX_VALUE;
		
		// 이분 탐색을 해보자...
		int s = 0; // 가장 왼쪽을 가리키는 포인터
		int e = N-1; // 가장 오른쪽을 가리키는 포인터
		while(s < e) {
			int sum = solutions[s] + solutions[e];
			
			if(minSum > Math.abs(sum)) {
				minSum = Math.abs(sum);
				s1 = solutions[s];
				s2 = solutions[e];
				
				if(sum == 0) break;
			}
			
			if(sum < 0) s++;
			else e--;
			
		}
		
		System.out.println(s1 + " " + s2);
	} // end of main
} // end of class
