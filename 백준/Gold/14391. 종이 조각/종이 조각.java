import java.io.*;
import java.util.*;

// 14391번 종이 조각 Gold3

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, answer;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 세로 길이, (1 ≤ N, M ≤ 4)
        M = Integer.parseInt(st.nextToken()); // 가로 길이

        paper = new int[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                paper[i][j] = str.charAt(j) - '0';
            }
        }

        backTracking(0, 0, new boolean[N][M], 0);

        System.out.println(answer);

    } // end of main

    private static void backTracking(int r, int c, boolean[][] curr, int sum) {
        if(c >= M) {
            backTracking(r+1, 0, curr, sum);
            return;
        }

        if(r >= N) {
            answer = Math.max(answer, sum);
            return;
        }

        if(curr[r][c]) {
            backTracking(r, c+1, curr, sum);
            return;
        }

        boolean[][] isSelected = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            isSelected[i] = curr[i].clone();
        }

        // 가로 방향으로 직사각형 만들기
length: for(int l = M-1; l >= 0; l--) { // 자를 직사각형의 길이
            if(c+l <= M-1) { // 현재 칸에서 오른쪽 방향으로 l 길이만큼의 직사각형을 만들 수 있다면
                String num = "";
                for(int j = c; j <= c+l; j++) {
                    if(!isSelected[r][j]) {
                        isSelected[r][j] = true;
                        num += paper[r][j] + "";
                    } else {
                        for(int k = 0; k < N; k++) { // 원상복구
                            isSelected[k] = curr[k].clone();
                        }
                        continue length;
                    }
                }

                backTracking(r, c + 1, isSelected, sum + Integer.parseInt(num));

                for(int i = 0; i < N; i++) { // 원상복구
                    isSelected[i] = curr[i].clone();
                }
            }
        }

        // 세로 방향으로 직사각형 만들기
length : for(int l = N-1; l >= 0; l--) { // 자를 직사각형의 길이
            if(r+l <= N-1) { // 현재 칸에서 아래 방향으로 l 길이만큼의 직사각형을 만들 수 있다면
                String num = "";
                for(int i = r; i <= r+l; i++) {
                    if(!isSelected[i][c]) {
                        isSelected[i][c] = true;
                        num += paper[i][c] + "";
                    } else {
                        for(int k = 0; k < N; k++) { // 원상복구
                            isSelected[k] = curr[k].clone();
                        }
                        continue length;
                    }
                }

                backTracking(r, c + 1, isSelected, sum + Integer.parseInt(num));


                for(int i = 0; i < N; i++) { // 원상복구
                    isSelected[i] = curr[i].clone();
                }
            }
        }
    }

} // end of class