import java.io.*;
import java.util.*;

// 2616번 소형기관차 Gold3

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, limit;
    static int[] carriage;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 객차의 수 (N <= 50,000)

        carriage = new int[N+1]; // carriage[i] <= 100
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            carriage[i] = carriage[i-1] + Integer.parseInt(st.nextToken());
        }

        limit = Integer.parseInt(br.readLine()); // limit < N/3

        dp = new int[3][N+1];

        // 1대 사용
        dp[0][limit] = carriage[limit];
        for(int j = limit+1; j <= N; j++) {
            dp[0][j] = Math.max(dp[0][j-1], carriage[j]-carriage[j-limit]);
        }

        // 2대 사용
        dp[1][limit*2] = carriage[limit*2];
        for(int j = limit*2+1; j <= N; j++) {
            dp[1][j] = Math.max(dp[1][j-1], dp[0][j-limit] + carriage[j]-carriage[j-limit]);
        }

        // 3대 사용
        dp[2][limit*3] = carriage[limit*3];
        for(int j = limit*3+1; j <= N; j++) {
            dp[2][j] = Math.max(dp[2][j-1], dp[1][j-limit] + carriage[j]-carriage[j-limit]);
        }

        System.out.println(dp[2][N]);

    } // end of main
} // end of class