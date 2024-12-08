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
            return;
        }

        // 1. (r, c)가 false인 상태로 2*2 정사각형 유무를 체크
        for(int i = r; i < N; i++) {
            for(int j = c; j < M; j++) {
                if(isSquare(i, j)) { // 현재 좌표가 반시계 방향으로 2*2 정사각형을 이루고 있으면
                    board[i][j] = false;

                    backTracking(i, j);
                    board[i][j] = true; // 원상복구
                }
            }
        }

        answer++;
        for(boolean[] b : board) {
            System.out.println(Arrays.toString(b));
        }
        System.out.println(answer + "개");

        // 2. (r, c)가 true인 상태로 2*2 정사각형 유무를 체크
        board[r][c] = true;
        for(int i = r; i < N; i++) {
            for(int j = c; j < M; j++) {
                if(isSquare(i, j)) { // 현재 좌표가 반시계 방향으로 2*2 정사각형을 이루고 있으면
                    board[i][j] = false;

                    backTracking(i, j);
                    board[i][j] = true; // 원상복구
                }
            }
        }

        answer++;
        for(boolean[] b : board) {
            System.out.println(Arrays.toString(b));
        }
        System.out.println(answer + "개");
    }

    // 빈시계 방향
    private static final int[][] dir = {{-1, 0}, {-1, -1}, {0, -1}};

    /**
     * 해당 좌표에서 반시계방향으로 2*2 정사각형을 이루는지 확인
     * @param r, @param c, @return
     */
    private static boolean isSquare(int r, int c) {
        if(!board[r][c]) return false;

        for(int d = 0; d < 3; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M || !board[nr][nc]) { // 범위를 벗어나거나 넴모넴모가 없는 경우
                return false;
            }
        }

        return true;
    }

} // end of class
