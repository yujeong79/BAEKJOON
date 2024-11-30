import java.io.*;
import java.util.*;

public class Main_1958_LCS3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] str1, str2, str3;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();
        str3 = br.readLine().toCharArray();

        dp = new int[str1.length+1][str2.length+1][str3.length+1];

        for(int i = 1; i <= str1.length; i++) {
            for(int j = 1; j <= str2.length; j++) {
                for(int k = 1; k <= str3.length; k++) {
                    if(str1[i-1] == str2[j-1] && str2[j-1] == str3[k-1]) {
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(Math.max(dp[i-1][j][k], dp[i][j-1][k]), dp[i][j][k-1]);
                    }
                }
            }
        }

        System.out.println(dp[str1.length][str2.length][str3.length]);

    } // end of main
} // end of class
