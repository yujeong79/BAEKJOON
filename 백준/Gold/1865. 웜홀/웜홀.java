import java.io.*;
import java.util.*;

/*
    음의 사이클이 있으면 YES 출력, 없으면 NO 출력
 */

public class Main {
    static class Edge {
        int s, e, t;

        Edge(int s, int e, int t) {
            this.s = s;
            this.e = e;
            this.t = t;
        }
    }

    static List<Edge> edges;
    static int[] dist;
    static int INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine()); // 1 ≤ TC ≤ 5
        while(TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); // 지점의 수, 1 ≤ N ≤ 500
            int M = Integer.parseInt(st.nextToken()); // 도로의 수, 1 ≤ M ≤ 2500
            int W = Integer.parseInt(st.nextToken()); // 웜홀의 수, 1 ≤ W ≤ 200

            edges = new ArrayList<>();
            for(int i = 0; i < M+W; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken()) - 1;
                int e = Integer.parseInt(st.nextToken()) - 1;
                int t = Integer.parseInt(st.nextToken()); // 0 ≤ t ≤ 10,000

                // 웜홀인 경우
                if(i >= M) { edges.add(new Edge(s, e, t*-1)); }
                else { // 도로인 경우
                    edges.add(new Edge(s, e, t));
                    edges.add(new Edge(e, s, t));
                }
            }

            dist = new int[N+1];
            INF = 500*10_000;
            Arrays.fill(dist, INF);

            if(bellmanFord(N)) sb.append("YES\n");
            else sb.append("NO\n");

        } // end of testcase

        System.out.println(sb);
    }

    static boolean bellmanFord(int N) {
        boolean isUpdated = false;

        for(int i = 0; i < N; i++) {
            isUpdated = false;

            for(Edge e : edges) {
                if(dist[e.e] > dist[e.s] + e.t) {
                    dist[e.e] = dist[e.s] + e.t;
                    isUpdated = true;
                }
            }
        }

        return isUpdated;
    }
}