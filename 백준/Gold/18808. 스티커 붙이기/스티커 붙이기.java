import java.io.*;
import java.util.*;

// 18808번 스티커 붙이기 Gold3
// https://www.acmicpc.net/problem/18808

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K, R, C, answer;
    static boolean[][] notebook, sticker;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 세로 길이, (1 ≤ N ≤ 40)
        M = Integer.parseInt(st.nextToken()); // 가로 길이, (1 ≤ M ≤ 40)
        K = Integer.parseInt(st.nextToken()); // 스티커의 개수, (1 ≤ K ≤ 100)

        notebook = new boolean[N][M];
        for(int k = 0; k < K; k++) { // 스티커 정보 입력 받기
            st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            sticker = new boolean[R][C];
            for(int r = 0; r < R; r++) {
                String str = br.readLine();
                for(int c = 0; c < C; c++) {
                    sticker[r][c] = str.charAt(c*2) == '1';
                }
            }

            selectPosition();
        }

        System.out.println(answer);
    } // end of main

    private static void selectPosition() {
        for(int angle = 0; angle < 4; angle++) {
            if(angle != 0) rotate();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(!notebook[i][j] || (notebook[i][j] && !sticker[0][0])) {
                        if (attach(i, j)) { // 스티커를 붙였으면 종료
                            return;
                        }
                    }

                    // 붙이지 못했다면 계속 진행
                }
            }

            // 현재 상태에서 붙일 수 있는 공간이 없다면 회전
        }
    }

    private final static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static void rotate() {
        int temp = R;
        R = C;
        C = temp;

        boolean[][] tempSticker = new boolean[R][C];
        for(int i = 0; i < C; i++) {
            Queue<Boolean> queue = new LinkedList<>();

            for(boolean b : sticker[i]) {
                queue.add(b);
            }

            for(int j = 0; j < R; j++) {
                tempSticker[j][C-1-i] = queue.poll();
            }
        }

        sticker = new boolean[R][C];
        for(int i = 0; i < R; i++) {
            sticker[i] = tempSticker[i].clone();
        }
    }

    private static boolean attach(int r, int c) {
        boolean[][] temp = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            temp[i] = notebook[i].clone();
        }

        boolean[][] isVisited = new boolean[R][C];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        int cnt = 0;
        if(sticker[0][0]) {
            temp[r][c] = true;
            isVisited[0][0] = true;
            cnt++;
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();

            for(int d = 0; d < 4; d++) {
                int nr = curr[0] + dir[d][0];
                int nc = curr[1] + dir[d][1];

                if(isRanged(nr, nc, R, C) && !isVisited[nr][nc]) {
                    int notebookR = r + nr;
                    int notebookC = c + nc;

                    if(!isRanged(notebookR, notebookC, N, M) || (temp[notebookR][notebookC] && sticker[nr][nc])) {
                        return false;
                    }

                    isVisited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                    if(sticker[nr][nc]) {
                        temp[r + nr][c + nc] = true;
                        cnt++;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++) {
            notebook[i] = temp[i].clone();
        }

        answer += cnt;

        return true;
    }

    private static boolean isRanged(int r, int c, int lastR, int lastC) {
        if(r >= 0 && r < lastR && c >= 0 && c < lastC)
            return true;

        return false;
    }

} // end of class