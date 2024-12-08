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

    // [0]:좌 [1]:좌상 [2]:상 [3]:초기 위치 [4]:우 [5]:우하 [6]:하
    private static final int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {0, 0}, {0, 1}, {1, 1}, {1, 0}};

    private static boolean isSquare(int r, int c) {
        if(!board[r][c]) return false;

        for(int currD = 0; currD <= 3; currD++) { // 현 위치에서 시계 방향으로 2*2 사각형을 이루는지 체크
            boolean square = true;

            int currR = r + dir[currD][0];
            int currC = c + dir[currD][1];

            for(int d = 3; d <= 6; d++) {
                int nr = currR + dir[d][0];
                int nc = currC + dir[d][1];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || !board[nr][nc]) {
                    square = false;
                    break;
                }
            }

            if(square) return true;
        }

        return false;
    }

} // end of class
