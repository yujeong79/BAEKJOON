import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] home = new int[N+1][3];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N+1][3];
        
        // 1번집 초기화
        dp[1][0] = home[1][0];
        dp[1][1] = home[1][1];
        dp[1][2] = home[1][2];

        for(int i = 2; i <= N; i++) { // 2번 ~ N번집 순회
            for(int color = 0; color < 3; color++) {
                int other = (color + 1)%3;
                int another = (color + 2)%3;

                dp[i][color] = Math.min(dp[i-1][other] + home[i][color], dp[i-1][another] + home[i][color]);
            }
        }

        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));

    }
}