import java.io.*;
import java.util.*;

public class Main_9252_LCS2 {
	static class Common {
		String sentence;
		int idx1;
		int idx2;

		public Common(String sentence, int idx1, int idx2) {
			this.sentence = sentence;
			this.idx1 = idx1;
			this.idx2 = idx2;
		}

		@Override
		public String toString() {
			return "Common [sentence=" + sentence + ", idx1=" + idx1 + ", idx2=" + idx2 + "]";
		}
		
	}
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int answerLength;
    static String answer;
    static char[] sentence1, sentence2;
    static List<Common> dp;
    
    public static void main(String[] args) throws IOException {
    	sentence1 = br.readLine().toCharArray();
    	sentence2 = br.readLine().toCharArray();
    	
    	dp = new ArrayList<>();
    	
    	for(int i = 0; i < sentence1.length; i++) {
    		for(int j = 0; j < sentence2.length; j++) {
    			if(sentence1[i] == sentence2[j]) {	
    				dp.add(new Common(sentence1[i]+"", i, j));
    			}
    		}
    	}
    	
    	String answer = "";
    	int maxSize = sentence1.length > sentence2.length ? sentence2.length : sentence1.length;
    	
    	for(int charCnt = 2; charCnt <= maxSize; charCnt++) { // 공통 문자열의 수를 1부터 1000까지 탐색
    		for(int dpIdx = 0; dpIdx < dp.size();  dpIdx++) {
    			Common com = dp.get(dpIdx);
    			
    			loop :
    			for(int i = com.idx1+1; i < sentence1.length; i++) {
    				for(int j = com.idx2+1; j < sentence2.length; j++) {
    					if(sentence1[i] == sentence2[j]) {
    						dp.get(dpIdx).sentence += sentence1[i]; // 문자 늘리기
    						
    						dp.get(dpIdx).idx1 = i;
    						dp.get(dpIdx).idx2 = j;
    						
    						answer = dp.get(dpIdx).sentence;
    						break loop;
    					}
    				}
    			}
    			
    		}
    	}
    	
    	System.out.println(answer.length());
    	if(answer.length() > 0) System.out.println(answer);
    	
    } // end of main
} // end of class
