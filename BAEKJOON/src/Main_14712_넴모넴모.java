import java.io.*;
import java.util.*;

public class Main_14712_넴모넴모 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static boolean[][] board;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // (1 ≤ N, M ≤ 25)
        M = Integer.parseInt(st.nextToken()); // (1 ≤ N × M ≤ 25)

        board = new boolean[N][M];

        backTracking();

    } // end of main

    private static void backTracking() {

    }
} // end of class
