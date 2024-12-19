import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n - 1; i++)
            arr[i] = new int[] { read(), read() };
        int k = read();
        int[][] dp = new int[n + 3][2];
        for (int i = 0; i < n + 3; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = dp[0][1] = 0;
        for (int i = 0; i < n - 1; i++) {
            dp[i + 1][0] = Math.min(dp[i + 1][0], dp[i][0] + arr[i][0]);
            dp[i + 2][0] = Math.min(dp[i + 2][0], dp[i][0] + arr[i][1]);
            dp[i + 3][1] = Math.min(dp[i + 3][1], dp[i][0] + k);
            dp[i + 1][1] = Math.min(dp[i + 1][1], dp[i][1] + arr[i][0]);
            dp[i + 2][1] = Math.min(dp[i + 2][1], dp[i][1] + arr[i][1]);
        }
        System.out.println(Math.min(dp[n - 1][0], dp[n - 1][1]));
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}