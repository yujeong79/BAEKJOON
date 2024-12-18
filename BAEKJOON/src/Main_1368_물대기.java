import java.io.*;
import java.util.*;

/**
 * 반례
 4
 100
 1
 3
 100
 0 100 1 4
 100 0 100 1
 1 100 0 5
 4 1 5 0
 */

public class Main_1368_물대기 {
    static class Connection implements Comparable<Connection>{
        int from, to, cost;

        public Connection(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Connection o) {
            return this.cost - o.cost;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, answer;
    static PriorityQueue<Connection> pq;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 논의 수

        pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            int cost = Integer.parseInt(br.readLine());
            pq.add(new Connection(0, i+1, cost)); // 가상의 루트 0이 있다고 가정
        }

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if(i != j) {
                    pq.add(new Connection(i, j, cost));
                }
            }
        }

        parents = new int[N+1];
        for(int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        int cnt = 0;
        while(cnt < N) {
            Connection curr = pq.poll();

            int fromParent = findSet(curr.from);
            int toParent = findSet(curr.to);
            
            if(fromParent != toParent) {
                union(fromParent, toParent);

                answer += curr.cost;
                cnt++;
            }
        }

        System.out.println(answer);

    } // end of main

    private static void union(int fromParent, int toParent) {
        parents[toParent] = fromParent;
    }

    private static int findSet(int node) {
        if(parents[node] != node) {
            return parents[node] = findSet(parents[node]);
        }

        return node;
    }


} // end of class
