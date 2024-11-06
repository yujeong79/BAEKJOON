import java.io.*;
import java.util.*;

public class Main_9252_LCS2 {	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static char[] sentence1, sentence2;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
    	sentence1 = br.readLine().toCharArray();
    	sentence2 = br.readLine().toCharArray();
    	
    	dp = new int[sentence1.length+1][sentence2.length+1];
    	
    	// LCS
    	for(int i = 1; i <= sentence1.length; i++) {
    		for(int j = 1; j <= sentence2.length; j++) {
    			if(sentence1[i-1] == sentence2[j-1]) {
    				dp[i][j] = dp[i-1][j-1]+1;
    			} else {
    				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    			}
    		}
    	}
    	
    	Stack<Character> st = new Stack<>();
    	int i = sentence1.length;
    	int j = sentence2.length;
    	
    	while(i > 0 && j > 0) {
    		if(dp[i][j] == dp[i-1][j]) {
    			i--;
    		} else if (dp[i][j] == dp[i][j-1]) {
    			j--;
    		} else {
    			st.add(sentence1[i-1]);
    			i--;
    			j--;
    		}
    	}
    	
    	String answer = "";
    	while(!st.isEmpty()) {
    		answer += st.pop();
    	}
    	
    	System.out.println(dp[sentence1.length][sentence2.length]);
    	System.out.println(answer);
    	
    } // end of main
} // end of class
