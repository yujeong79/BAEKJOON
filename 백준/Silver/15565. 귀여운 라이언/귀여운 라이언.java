import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 1 ≤ N ≤ 1,000,000
		int K = Integer.parseInt(st.nextToken()); // 1 ≤ K ≤ 1,000,000
		
		boolean[] isLion = new boolean[N];
		String input = br.readLine();
		for(int i = 0; i < N; i++) {
			if(input.charAt(i*2) == '1')
				isLion[i] = true;
		}
		
		int l = 0; while(l < N-1 && !isLion[++l]) {}
		int r = l+1;
		int lion = 1;
		int answer = Integer.MAX_VALUE;
		while(r < N && l <= r) {
			if(isLion[r]) { // 라이언 인형인 경우
				lion++; // 라이언 인형의 개수 +1
				
				if(lion >= K) { // 라이언 인형의 개수가 K개 이상이 된 경우
					answer = Math.min(answer, r-l+1);
					
					while(!isLion[++l]) {} // 왼쪽 포인터를 다음 라이언 인형으로 옮기기
					lion--; // 라이언 인형의 개수 -1
				}
			}
			
			r++; // 오른쪽 포인터 옮기기
		}
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
}