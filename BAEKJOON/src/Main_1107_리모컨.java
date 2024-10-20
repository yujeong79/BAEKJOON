import java.io.*;

public class Main_1107_리모컨 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, currChannelInt, minCnt;
	static boolean[] buttons = new boolean[10];
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 이동하려고 하는 채널
		M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수
		
		if(M > 0) {
			String brokenButtons = br.readLine();
			for(int i = 0, ci = 0; i < M; i++, ci += 2) {
				int idx = brokenButtons.charAt(ci)-'0';
				buttons[idx] = true;
			}
		}
		
		minCnt = Integer.MAX_VALUE;
		currChannelInt = 0;
		
		while(currChannelInt <= 1000000) {
			String currChannelString = currChannelInt+"";
			int currChannelLength = currChannelString.length();
			boolean flag = true;
			
			for(int i = 0; i < currChannelLength; i++) {
				int idx = currChannelString.charAt(i) - '0';
				if(buttons[idx]) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				int cnt = Math.abs(N - currChannelInt) + currChannelLength;
				if(minCnt < cnt) break;
				else minCnt = cnt;
			}
			
			currChannelInt++;
		}
		
		
		minCnt = Math.min(Math.abs(minCnt), Math.abs(N-100));
		
		System.out.println(minCnt);
		
	} // end of main
} // end of class