import java.io.*;
import java.util.*;

public class Main_16234_인구이동 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, L, R, answer;
    static int[][] map;
    static boolean[][] isVisited;
    static Queue<int[]> alliance;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // (1 ≤ N ≤ 50)
        L = Integer.parseInt(st.nextToken()); // (1 ≤ L ≤ R ≤ 100)
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // (0 ≤ A[r][c] ≤ 100)
            }
        }

        while(true) {
            int moveCnt = 0;
            isVisited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isVisited[i][j] && bfs(i, j)) {
                        moveCnt++;
                    }
                }
            }

            if(moveCnt <= 0) break;

            answer++;
        }

        System.out.println(answer);

    } // end of main

    private final static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static boolean bfs(int r, int c) {
        int peopleCnt = 0;
        int countryCnt = 0;
        alliance = new LinkedList<>();

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r,c});
        isVisited[r][c] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();

            alliance.add(new int[] {curr[0], curr[1]});
            countryCnt++;
            peopleCnt += map[curr[0]][curr[1]];

            for(int d = 0; d < 4; d++) {
                int nr = curr[0] + dir[d][0];
                int nc = curr[1] + dir[d][1];

                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !isVisited[nr][nc]) {
                    if(Math.abs(map[curr[0]][curr[1]] - map[nr][nc]) >= L && Math.abs(map[curr[0]][curr[1]] - map[nr][nc]) <= R) {
                        isVisited[nr][nc] = true;
                        queue.add(new int[] {nr, nc});
                    }
                }
            }
        }

        if(countryCnt > 1) {
            move(peopleCnt / countryCnt);
            return true;
        }
        return false;

    }

    private static void move(int cnt) {
        while(!alliance.isEmpty()) {
            int[] curr = alliance.poll();

            map[curr[0]][curr[1]] = cnt;
        }
    }

} // end of class
