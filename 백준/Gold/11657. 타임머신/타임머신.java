import java.io.*;
import java.util.*;

public class Main {
    static class Bus {
        int start, end, weight;

        Bus(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static long[] dist;
    static Bus[] buses;
    static int INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 1 ≤ N ≤ 500
        int M = Integer.parseInt(st.nextToken()); // 1 ≤ M ≤ 6,000
        INF = Integer.MAX_VALUE;

        dist = new long[N];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        buses = new Bus[M];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());

            buses[i] = new Bus(s, e, w);
        }

        if(bellmanFord(N)) {
            sb.append("-1\n");
        } else {
            for(int i = 1; i < N; i++) {
                if(dist[i] != INF) sb.append(dist[i] + "\n");
                else sb.append("-1\n");
            }
        }

        System.out.println(sb);
    }

    static boolean bellmanFord(int N) {
        boolean isMinusCycle = false;

        for(int i = 0; i < N; i++) {
            for(Bus bus : buses) {
                if(dist[bus.start] == INF) continue;

                // 0 -> start -> end 가는 것이 더 최단거리인 경우
                dist[bus.end] = Math.min(dist[bus.end], dist[bus.start] + bus.weight);
            }
        }

        for(Bus bus : buses) {
            if(dist[bus.start] == INF) continue;

            if(dist[bus.end] > dist[bus.start] + bus.weight) {
                isMinusCycle = true;
                break;
            }
        }

        return isMinusCycle;
    }
}