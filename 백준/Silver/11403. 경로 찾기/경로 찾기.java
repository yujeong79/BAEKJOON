import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[][] distance = new int[N][N];
        int INF = 1_000_000;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                int curr = Integer.parseInt(st.nextToken());
                if(curr == 1) { // 본인이거나 간선이 있는 경우
                    distance[i][j] = curr;
                } else { // 간선이 없는 경우
                    distance[i][j] = INF;
                }
            }
        }

        // i -> k -> j 이동
        for(int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(distance[i][k] >= INF || distance[k][j] >= INF)
                        continue;

                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(distance[i][j] < INF) sb.append("1 ");
                else sb.append("0 ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
