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
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static List<Flow> flows;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        flows = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if(i != j) {
                    flows.add(new Flow(i, j, cost));
                }
            }
        }

        Collections.sort(flows);

    } // end of main
} // end of class
