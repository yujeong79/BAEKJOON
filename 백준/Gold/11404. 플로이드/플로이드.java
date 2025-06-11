import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); // 2 ≤ n ≤ 100
        int m = Integer.parseInt(br.readLine()); // 1 ≤ m ≤ 100,000

        int INF = 100_000_000;
        int[][] distance = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken()); // 1 ≤ cost ≤ 100,000

            distance[start][end] = Math.min(distance[start][end], cost);
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(distance[i][k] >= INF || distance[k][j] >= INF)
                        continue;

                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        // i == j인 경우에 어떻게 했나?
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(distance[i][j] >= INF) sb.append(0 + " ");
                else sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}