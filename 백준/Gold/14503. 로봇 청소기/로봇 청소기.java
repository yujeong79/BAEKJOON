import java.io.*;
import java.util.*;

public class Main {
    static class Vacuum {
        int r, c, d;

        public Vacuum() {
        }

        public Vacuum(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d; // 0:상 1:우 2:하 3:좌
        }

        @Override
        public String toString() {
            return "Vacuum{" +
                    "r=" + r +
                    ", c=" + c +
                    ", d=" + d +
                    '}';
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, answer;
    static char[][] room;
    static boolean[][] isCleaned;
    static Vacuum vacuum;

    public static void init() {
        room = new char[N][M];
        isCleaned = new boolean[N][M];
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // (3 <= N, M <= 50)
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        vacuum = new Vacuum(r, c, d);

        init();

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                room[i][j] = str.charAt(j*2);
            }
        }

        cleanUp();

        System.out.println(answer);
    } // end of main

    // 상 우 하 좌
    static final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static void cleanUp() {
        while(true) {
            if(!isCleaned[vacuum.r][vacuum.c]) {
                isCleaned[vacuum.r][vacuum.c] = true; // 현재 칸을 청소한다.
                answer++;
            }

            boolean flag = false;

            for (int d = 0; d < 4; d++) {
                int nr = vacuum.r + dir[d][0];
                int nc = vacuum.c + dir[d][1];

                if (room[nr][nc] == '0' && !isCleaned[nr][nc]) { // 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                    flag = true;
                    vacuum.d = (vacuum.d + 3) % 4; // 반시계 방향으로 90도 회전

                    int frontR = vacuum.r + dir[vacuum.d][0];
                    int frontC = vacuum.c + dir[vacuum.d][1];
                    if (room[frontR][frontC] == '0' && !isCleaned[frontR][frontC]) { // 바라보는 방향을 기준으로 앞 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
                        vacuum.r = frontR;
                        vacuum.c = frontC;
                    }

                    break; // 다시 1번으로 돌아간다.
                }
            }

            // 현재 칸의 주변으로 청소되지 않은 빈 칸이 없는 경우
            if(!flag) {
                int backwardD = (vacuum.d + 2) % 4;
                int nr = vacuum.r + dir[backwardD][0];
                int nc = vacuum.c + dir[backwardD][1];

                if (room[nr][nc] == '0') { // 한 칸 후진할 수 있다면
                    vacuum.r = nr;
                    vacuum.c = nc;
                } else {
                    return; // 후진할 수 없다면 작동을 멈춘다.
                }
            }
        }
    }

} // end of class