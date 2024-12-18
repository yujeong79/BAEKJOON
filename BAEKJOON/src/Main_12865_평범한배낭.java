import java.io.*;
import java.util.*;

public class Main_12865_평범한배낭 {
    static class Item implements Comparable<Item> {
        int w, v;

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Item o) {
            return this.w - o.w;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static Item[] items;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 물건의 수 (1 ≤ N ≤ 100)
        K = Integer.parseInt(st.nextToken()); // 무게 제한 (1 ≤ K ≤ 100,000)

        items = new Item[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken()); // 해당 물건의 무게 (1 ≤ W ≤ 100,000)
            int value = Integer.parseInt(st.nextToken()); // 해당 물건의 가치 (0 ≤ V ≤ 1,000)

            items[i] = new Item(weight, value);
        }

        Arrays.sort(items);

        dp = new int[N+1][K+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                if(items[i-1].w <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i-1].w]+items[i-1].v);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][K]);

    } // end of main
} // end of class
