import java.io.*;
import java.util.*;

// 1463번 1로 만들기 Silver3

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] dp;

    static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        dp = new int[3][N+1];

        for(int i = 1; i < 3; i++) { // 초기화
            Arrays.fill(dp[i], MAX);
            dp[i][0] = dp[i][1] = 0;
        }

        for(int i = 2; i <= N; i++) { // 1 빼기
            dp[0][i] = i - 1;
        }

        for(int i = 2; i <= N; i++) { // 2로 나누기
            if(i % 2 == 0 && i % 3 == 0) {
                dp[1][i] = Math.min(Math.min(dp[1][i/2] + 1, dp[1][i/3] + 1), dp[0][i]);
            }

            else if(i % 2 == 0) { // X가 2로 나누어 떨어지면, 2로 나눈다.
                dp[1][i] = Math.min(dp[1][i/2] + 1, dp[0][i]);
            }

            else {
               dp[1][i] = Math.min(dp[1][i-1] + 1, dp[0][i]);
            }
        }

        for(int i = 2; i <= N; i++) { // 3으로 나누기
            if(i % 2 == 0 && i % 3 == 0) {
                dp[2][i] = Math.min(Math.min(dp[2][i/2] + 1, dp[2][i/3] + 1), dp[1][i]);
            }

            else if(i % 3 == 0) {
                dp[2][i] = Math.min(Math.min(Math.min(dp[2][i-1] + 1, dp[2][i-2] + 2), dp[2][i/3] + 1), dp[1][i]);
            }

            else if(i % 2 == 0) {
                dp[2][i] = Math.min(Math.min(Math.min(dp[2][i-1] + 1, dp[2][i-2] + 2), dp[2][i/2] + 1), dp[1][i]);
            }

            else {
                dp[2][i] = Math.min(Math.min(dp[2][i-1] + 1, dp[2][i-2] + 2), dp[1][i]);
            }

        }

//        for(int[] arr : dp) {
//            for(int i = 0; i <= N; i++) {
//                System.out.print(i + "(" + arr[i] + "개), ");
//            }
//            System.out.println();
//        }
        
        System.out.println(dp[2][N]);

    } // end of main
} // end of class