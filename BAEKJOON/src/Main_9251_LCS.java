import java.io.*;
import java.util.*;

public class Main_9251_LCS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] str1, str2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        dp = new int[str2.length+1][str1.length+1];

        for(int i = 1; i <= str2.length; i++) {
            for(int j = 1; j <= str1.length; j++) {
                if(str1[j-1] == str2[i-1]) // 같은 문자인 경우에는
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        System.out.println(dp[str2.length][str1.length]);

    } // end of main
} // end of class
