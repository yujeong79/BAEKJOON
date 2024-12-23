import java.io.*;
import java.util.*;

// 2665번 미로만들기 Gold5

public class Main {
    public static class Point implements Comparable<Point>{
        int r, c, cost;

        public Point(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point other) {
            return this.cost - other.cost;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine()); // (1 ≤ n ≤ 50)

        map = new char[n][n];
        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dijkstra();

        System.out.println(minCost[n-1][n-1]);
        
    } // end of main

    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int[][] minCost;
    static PriorityQueue<Point> pq;

    private static void dijkstra() {
        minCost = new int[n][n];
        for(int[] arr : minCost) {
            Arrays.fill(arr, 3000);
        }
        
        pq = new PriorityQueue<>();

        pq.add(new Point(0, 0, 0));

        while(!pq.isEmpty()) {
            Point curr = pq.poll();

            if(minCost[curr.r][curr.c] < curr.cost) continue;

            for(int d = 0; d < 4; d++) {
                int nr = curr.r + dir[d][0];
                int nc = curr.c + dir[d][1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int extraCost = map[nr][nc] == '1' ? 0 : 1;

                    if(minCost[nr][nc] > curr.cost + extraCost) {
                        minCost[nr][nc] = curr.cost + extraCost;
                        pq.add(new Point(nr, nc, minCost[nr][nc]));
                    }
                }
            }
        }
    }

} // end of class