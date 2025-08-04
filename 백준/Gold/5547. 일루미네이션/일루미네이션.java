import java.io.*;
import java.util.*;

public class Main {
    static int W, H;
    static int[][] oddDir = {{-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};
    static int[][] evenDir = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, -1}, {1, 0}};
    static int[][] map;
    static boolean[][] isVisited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H+2][W+2];
        isVisited = new boolean[H+2][W+2];
        for(int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        isVisited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();

            for(int d = 0; d < 6; d++) {
                int nr, nc;

                if(curr[0] % 2 != 0) { // 홀수인 경우
                    nr = curr[0] + oddDir[d][0];
                    nc = curr[1] + oddDir[d][1];
                } else {
                    nr = curr[0] + evenDir[d][0];
                    nc = curr[1] + evenDir[d][1];
                }

                if(nr < 0 || nr >= H+2 || nc < 0 || nc >= W+2)
                    continue;

                if(map[nr][nc] == 1) {
                    answer++;
                }
                if(map[nr][nc] == 0 && !isVisited[nr][nc]) {
                    isVisited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}