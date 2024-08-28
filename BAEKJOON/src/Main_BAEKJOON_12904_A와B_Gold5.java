import java.io.*;
import java.util.*;

public class Main_BAEKJOON_12904_A와B_Gold5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int idx = 0;
	
	static List<Character> sList;
	
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		sList = new ArrayList<>();
		for(int i = 0; i < str.length(); i++) {
			sList.add(str.charAt(i));
		}
		
		char[] T = br.readLine().toCharArray();
		
		boolean flag = true;
		
		while(flag && sList.size() < T.length) { // sList가 T만큼의 문자열을 완성하면 종료
			List<Character> tmp = sList;
			
			// 일단 A를 추가해봐
			tmp.add('A');
			for(int i = 0; flag && i < tmp.size(); i++) {
				//System.out.println(tmp.get(i) + ", " + T[i]);
				if(tmp.get(i) != T[i]) flag = false;
			}
			
			// A 추가했는데 안됐어?
			if(!flag) {
				flag = true;
				Collections.reverse(tmp); // 그러면 뒤집어봐
				for(int i = 0; flag && i < tmp.size(); i++) {
					if(tmp.get(i) != T[i]) flag = false;
				}
				if(flag) { // 뒤집었는데 같으면 B를 넣어야해
					tmp.add('B');
				}
			}
			
			if(!flag) { // A를 추가하고 뒤집어서 	비교도 했는데 안됐어?
				tmp.remove(tmp.size()-1); // 원래 추가했던 A를 일단 빼고
				flag = true; // flag도 일단 true 해놔
				
				Collections.reverse(tmp);
				tmp.add('B');
				for(int i = 0; flag && i < tmp.size(); i++) {
					//System.out.println(tmp.get(i) + ", " + T[i]);
					if(tmp.get(i) != T[i]) flag = false;
				}
			}
			
			if(flag) sList = tmp;
		} 
		
		System.out.println(flag ? 1 : 0);
	} // end of main
} // end of class
