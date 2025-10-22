import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String address = sc.next();
		
		StringTokenizer st = new StringTokenizer(address, ":");
		int parts = 0;
		while(st.hasMoreTokens()) {
			String part = st.nextToken();
			parts++;
		}
		
		int length = address.length();
		int idx = 0;
		while(idx < length) {
			if(address.charAt(idx) == ':') {
				for(int i = 0; i < 8 - parts; i++) {
					if(sb.length() == 0) sb.append("0000");
					else sb.append(":0000");
				}
                
                while(idx < length && address.charAt(idx) == ':') idx++;
				continue;
			}
			
			String result = "";
			while(idx < length && address.charAt(idx) != ':') {
				result += address.charAt(idx);
				idx++;
			}
			
			if(result.length() < 4) {
				int cnt = 4 - result.length();
				
				for(int i = 0; i < cnt; i++) {
					result = "0" + result;
				}
			}
			
			if(sb.length() == 0) sb.append(result);
			else sb.append(":").append(result);
			
			idx++;
		}
		
		System.out.println(sb);
	}
}