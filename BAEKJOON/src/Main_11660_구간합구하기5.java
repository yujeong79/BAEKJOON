import java.io.*;
import java.util.*;

public class Main_11660_구간합구하기5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[][] table;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // (1 ≤ N ≤ 1024)
        M = Integer.parseInt(st.nextToken()); // (1 ≤ M ≤ 100,000)

        table = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j  <= N; j++) {
                table[i][j] = table[i-1][j] + table[i][j-1] - table[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(table[x2][y2] - table[x1-1][y2] - table[x2][y1-1] + table[x1-1][y1-1]).append("\n");
        }

        System.out.println(sb);

    } // end of main
} // end of class
