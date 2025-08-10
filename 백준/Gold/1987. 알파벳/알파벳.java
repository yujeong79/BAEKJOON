import java.io.*;
import java.util.*;

public class Main {
    static int R, C, answer;
    static char[][] board;
    static boolean[] alphabet;
    static boolean[][] isVisited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // (1 <= R, C <= 20)
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for(int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        isVisited = new boolean[R][C];
        isVisited[0][0] = true;

        alphabet = new boolean[26];
        alphabet[board[0][0]-'A'] = true;

        dfs(0, 0, 1);

        System.out.println(answer);

    }

    public static void dfs(int r, int c, int length) {
        answer = Math.max(answer, length);

        for(int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if(nr >= 0 && nr < R && nc >= 0 && nc < C && !isVisited[nr][nc] && !alphabet[board[nr][nc] - 'A']) {
                isVisited[nr][nc] = true;
                alphabet[board[nr][nc] - 'A'] = true;

                dfs(nr, nc, length+1);

                isVisited[nr][nc] = false;
                alphabet[board[nr][nc] - 'A'] = false;
            }
        }
    }

}