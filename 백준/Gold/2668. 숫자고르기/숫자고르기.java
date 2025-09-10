import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		N = sc.nextInt(); // 1 ≤ N ≤ 100
		arr = new int[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		List<Integer> answer = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			if(isCycle(i)) answer.add(i);
		}
		
		Collections.sort(answer);
		sb.append(answer.size()).append("\n");
		for(int n : answer) {
			sb.append(n).append("\n");
		}
		
		System.out.println(sb);
	}

	public static boolean isCycle(int num) {
        boolean[] isVisited = new boolean[N+1];
		isVisited[num] = true;
		int visitedCnt = 1;
		
		while(visitedCnt < N) {
			if(isVisited[arr[num]]) {
				return true;
			}
			
			num = arr[num];
			visitedCnt++;
		}
		
		return false;
	}
}