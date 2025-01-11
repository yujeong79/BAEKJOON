import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int[][] board;
    static boolean[][] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        N = str.charAt(0) - '0';
        M = str.charAt(2) - '0';

        board = new int[N][M];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = Integer.MIN_VALUE;
        isSelected = new boolean[N][M];
        backTracking(0, 0, 0);

        System.out.println(ans);
        
    } // end of main

    private final static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}}; // 상 좌 하 우 상

    private static void backTracking(int r, int c, int sum) {
        if(c >= M) {
            backTracking(r+1, 0, sum);
            return;
        }

        if(r >= N) {
            ans = Math.max(ans, sum);
            return;
        }

        if(isSelected[r][c]) {
            backTracking(r, c+1, sum);
            return;
        }

        for(int i = 1; i <= 4; i++) {
            if(isPossible(r, c, i-1, i)) {
                int curr = board[r][c] * 2 + board[r+dir[i-1][0]][c+dir[i-1][1]] + board[r+dir[i][0]][c+dir[i][1]];

                isSelected[r][c] = true;
                isSelected[r+dir[i-1][0]][c+dir[i-1][1]] = true;
                isSelected[r+dir[i][0]][c+dir[i][1]] = true;

                backTracking(r, c+1, sum + curr);

                isSelected[r][c] = false;
                isSelected[r+dir[i-1][0]][c+dir[i-1][1]] = false;
                isSelected[r+dir[i][0]][c+dir[i][1]] = false;
            }
        }

        backTracking(r, c+1, sum);

    }

    private static boolean isPossible(int r, int c, int coord1, int coord2) {
        for(int d = coord1; d <= coord2; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M || isSelected[nr][nc]) {
                return false;
            }
        }

        return true;
    }

} // end of class