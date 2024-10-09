import java.io.*;
import java.util.*;

/**
 * 벽을 하나씩 부수고 BFS 돌리기
 * 방법1. 입력받을 때 벽의 위치를 queue에 저장하고, queue의 모든 벽을 하나씩 빼서 '0'으로 바꿔봄으로써 최단 경로 찾기 => 시간 초과
 * 방법2. 0, 0부터 BFS를 돌리면서 해당 경로를 탐색하면서 벽을 이제껏 한 번도 안부셨으면 부수고, 이미 한 번 부셨으면 탐색 종료하며 최단 경로 찾기 => 실패, 이미 벽을 부순 상태에서 방문한 지점을 벽을 안부수고 탐색할 수 없음
 * 방법3. 벽을 부순 경우와 벽을 안부순 경우의 방문 체크를 나눠서 체크할 수 있도록 3차원 배열을 사용하기
 */

public class Main_2206_벽부수고이동하기 {
    // BFS의 Queue에 담기 위한 Point 클래스
    static class Point {
        int r, c, dist, isBroken;

        public Point(int r, int c, int dist, int isBroken) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.isBroken = isBroken; // 해당 지점을 지나기 전까지의 경로에서 벽을 부순 적이 있는지 체크(0 : 벽을 부수지 않은 것/1 : 벽을 부순 것)
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, minDist;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // (1 ≤ N ≤ 1,000)
        M = Integer.parseInt(st.nextToken()); // (1 ≤ M ≤ 1,000)

        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        minDist = Integer.MAX_VALUE; // 최단 거리 초기화
        BFS();

        minDist = minDist == Integer.MAX_VALUE ? -1 : minDist; // BFS 탐색을 종료한 이후에도 최단 거리가 초기화 상태와 같으면 목적지에 방문하지 못했단 의미이므로 -1 출력

        System.out.println(minDist);
    } // end of main

    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][][] isVisited = new boolean[2][N][M]; // isVisited[0] : 벽을 부수지 않은 경우에 방문 체크, isVisited[1] : 벽을 부순 경우에 방문 체크

        queue.offer(new Point(0, 0, 1, 0));
        isVisited[0][0][0] = true;

        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            if(curr.dist > minDist) return; // 이미 최단경로를 넘었다면 더 탐색할 필요가 없으므로 종료

            if(curr.r == N-1 && curr.c == M-1) { // 목적지에 도달했다면 minDist 갱신
                minDist = curr.dist;
                return;
            }

            for(int d = 0; d < 4; d++) {
                int nr = curr.r + dir[d][0];
                int nc = curr.c + dir[d][1];

                if(nr >= 0 && nr < N && nc >= 0 && nc < M) { // 새로운 좌표가 범위 안에 있으면
                    if(map[nr][nc] == '0' && !isVisited[curr.isBroken][nr][nc]) { // 벽이 아니고 아직 방문하지 않았다면
                        queue.offer(new Point(nr, nc, curr.dist+1, curr.isBroken));
                        isVisited[curr.isBroken][nr][nc] = true; // isVistied[0]에 방문체크
                    } else if(map[nr][nc] == '1' && curr.isBroken == 0 && !isVisited[curr.isBroken][nr][nc]) { // 벽이지만 아직 한 번도 벽을 부수지 않았다면
                        queue.offer(new Point(nr, nc, curr.dist+1, 1));
                        isVisited[1][nr][nc] = true; // isVisited[1]에 방문체크
                    }
                }
            }

        }

    } // end of method

} // end of class
