import java.io.*;
import java.util.*;

public class Main_14712_넴모넴모 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, answer;
    static boolean[][] board;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // (1 ≤ N, M ≤ 25)
        M = Integer.parseInt(st.nextToken()); // (1 ≤ N × M ≤ 25)

        board = new boolean[N][M];

        backTracking(0, 0);

        System.out.println(answer);

    } // end of main

    private static void backTracking(int r, int c) {
        if(c >= M) {
            backTracking(r+1, 0);
            return;
        }

        if(r >= N) {
            answer++;
            return;
        }

        // 현상태가 2*2 정사각형을 이루는 배치가 아닐 경우
        board[r][c] = true;
        if(!isSquare(r, c)) {
            backTracking(r, c+1);
        }

        board[r][c] = false;
        backTracking(r, c+1);

    }

    private static final int[][] dir = {{-1, -1}, {-1, 0}, {0, -1}};

    private static boolean isSquare(int r, int c) {
        if(!board[r][c]) return false;

        for(int d = 0; d <= 2; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M || !board[nr][nc]) {
                return false;
            }
        }

        return true;
    }

} // end of class
