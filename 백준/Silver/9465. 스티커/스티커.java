import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[][] sticker = new int[2][N+1];
            for(int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 1; j <= N; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][N+1];
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];


            for(int j = 2; j <= N; j++) {
                int up = dp[0][j-2];
                int down = dp[1][j-2];

                dp[0][j] = Math.max(Math.max(up + sticker[0][j], down + sticker[0][j]), dp[1][j-1] + sticker[0][j]);
                dp[1][j] = Math.max(Math.max(up + sticker[1][j], down + sticker[1][j]), dp[0][j-1] + sticker[1][j]);
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));

        } // end of testCase

    } // end of main
} // end of class