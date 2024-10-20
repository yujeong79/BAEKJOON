import java.io.*;
import java.util.*;

/**
 * 수빈이가 현재 보고 있는 채널은 100번
 */

public class Main_1107_리모컨 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, curr, minCnt;
	static boolean[] buttons = new boolean[10];
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 이동하려고 하는 채널
		
		M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수
		
		Arrays.fill(buttons, true);
		
		if(M > 0) {
			String brokenButtons = br.readLine();
			for(int i = 0; i < M; i++) {
				int idx = brokenButtons.charAt(i*2)-'0';
				buttons[idx] = false;
			}
		}
		
		minCnt = Integer.MAX_VALUE;
		curr = 0;
		
		while(curr <= N) { // 현재 채널이 N번이 될 때까지
			char[] channelArr = (curr+"").toCharArray();
			boolean flag = true;
			
			for(int i = 0; i < channelArr.length; i++) {
				int idx = channelArr[i] - '0';
				if(!buttons[idx]) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				int cnt = N - curr + (curr+"").length();
				minCnt = Math.min((cnt), minCnt);
			}
				
			curr++;
		}
		
		curr = N + minCnt;
		
		while(curr >= N) {
			char[] channelArr = (curr+"").toCharArray();
			boolean flag = true;
			
			for(int i = 0; i < channelArr.length; i++) {
				int idx = channelArr[i] - '0';
				if(!buttons[idx]) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				int cnt = curr - N + (curr+"").length();
				minCnt = Math.min((cnt), minCnt);
			}
				
			curr--;
		}
		
		
		minCnt = Math.min(Math.abs(minCnt), Math.abs(N-100));
		
		System.out.println(minCnt);
		
	} // end of main
} // end of class
