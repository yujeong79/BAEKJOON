import java.io.*;
import java.util.*;

public class Main_2294_동전2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 동전 종류, (1 ≤ n ≤ 100)
        K = Integer.parseInt(st.nextToken()); // 원하는 가치의 합, (1 ≤ k ≤ 10,000)

        coins = new int[N];
        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);

        dp = new int[K+1];

        for(int c = 0; c < N; c++) {
            for(int curr = 1; curr <= K; curr++) {
                if(c == 0) { // 첫번째 동전의 dp는 다 채워놓자!
                    if(curr % coins[c] == 0) {
                        dp[curr] = curr / coins[c];
                    } else {
                        dp[curr] = -1;
                    }
                }

                else if (coins[c] <= curr) {
                    for(int i = curr / coins[c]; i >= 1; i--) {
                        int currCoin = coins[c] * i;

                        if (dp[curr - currCoin] >= 0) { // curr원 만들기 가능
                            int cnt = (i + dp[curr - currCoin]);
                            if (dp[curr] < 0) dp[curr] = cnt;
                            else dp[curr] = Math.min(dp[curr], cnt);

                            break;
                        }

                        // 불가능한 경우에는 그냥 두면 됨
                    }
                }
            }

//            System.out.println("현재 동전 : " + coins[c] + " " + Arrays.toString(dp));
        }

        System.out.println(dp[K]);

    } // end of main
} // end of class
