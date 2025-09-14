import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			String W = br.readLine();			
			int K = Integer.parseInt(br.readLine());
			
			if(K == 1) {
				sb.append("1 1\n");
				continue;
			}
			
			int[] alphabet = new int[26];
			for(int i = 0; i < W.length(); i++) {
				alphabet[W.charAt(i)-'a']++;
			}
			
			int min = Integer.MAX_VALUE;
			int max = 0;
			for(int i = 0; i < W.length(); i++) {
				if(alphabet[W.charAt(i)-'a'] < K)
					continue;
				
				int cnt = 1;
				for(int j = i+1; j < W.length(); j++) {
					if(W.charAt(i) == W.charAt(j)) cnt++;
					if(cnt == K) {
						min = Math.min(min, j - i + 1);
						max = Math.max(max, j - i + 1);
						break;
					}
				}
			}
			
			if(min == Integer.MAX_VALUE || max == 0)
				sb.append("-1\n");
			else {
				sb.append(min).append(" ").append(max).append("\n");
			}
			
		} // end of test case
		
		System.out.println(sb);
	}
}