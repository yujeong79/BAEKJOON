import java.io.*;
import java.util.*;

public class Main_16398_행성연결 {
    static class Flow implements Comparable<Flow> {
        int planet1, planet2, cost;

        public Flow(int planet1, int planet2, int cost) {
            this.planet1 = planet1;
            this.planet2 = planet2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Flow o) {
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "Flow{" +
                    "planet1=" + planet1 +
                    ", planet2=" + planet2 +
                    ", cost=" + cost +
                    '}';
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long answer;
    static PriorityQueue<Flow> flows;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // (1 ≤ N ≤ 1000)

        flows = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                int cost = Integer.parseInt(st.nextToken()); // (1 ≤ Cij ≤ 100,000,000)
                if(i != j) {
                    flows.add(new Flow(i, j, cost));
                }
            }
        }

        parents = new int[N];
        for(int i = 0; i < N; i++) {
            parents[i] = i;
        }

        int flowCnt = 0;
        while(flowCnt < N-1) {
            Flow curr = flows.poll();

            int parent1 = findSet(curr.planet1);
            int parent2 = findSet(curr.planet2);

            if(parent1 != parent2) {
                union(parent1, parent2);

                answer += curr.cost;
                flowCnt++;
            }
        }

        System.out.println(answer);

    } // end of main

    private static void union(int parent1, int parent2) {
        parents[parent2] = parent1;
    }

    private static int findSet(int planet) {
        if(parents[planet] != planet)
            return parents[planet] = findSet(parents[planet]);

        return planet;
    }


} // end of class
