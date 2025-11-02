import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int L;
	static int C;
	
	static String[] alphabet;
	static String[] result;
	
	static List<String> words;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken()); // L 크기의 조합
		C = Integer.parseInt(st.nextToken()); // C개의 문자
		
		alphabet = new String[C]; // 입력 받은 배열
		result = new String[L]; // L 크기의 조합
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken();
		}
		
		Arrays.sort(alphabet);
		
		words = new ArrayList<>();
		comb(0, 0);
		
		System.out.println(sb);
		
	} // end of main
	
	static void comb(int cnt, int start) {
		if(cnt == L) {
			String word = "";
			for(String c : result) word += c;
			if(isPossible(word)) sb.append(word).append("\n");
			return;
		}
		
		for(int i = start; i < C; i++) {
			result[cnt] = alphabet[i];
			comb(cnt+1, i+1);
		}
	}
	
	static boolean isPossible(String str) {
		int consonant = 0; // 자음
		int vowel = 0; // 모음
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowel++;
			else consonant++;
		}
		
		if(vowel >= 1 && consonant >= 2) return true;
		return false;
	}
	
} // end of class
