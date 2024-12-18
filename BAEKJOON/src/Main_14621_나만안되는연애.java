import java.io.*;
import java.util.*;

public class Main_14621_나만안되는연애 {
    static class Road implements Comparable<Road>{
        int from, to, distance;

        public Road(int from, int to, int distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Road o) {
            return this.distance - o.distance;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, answer;
    static boolean[] university;
    static PriorityQueue<Road> roads;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 학교의 수(2 ≤ N ≤ 1,000)
        M = Integer.parseInt(st.nextToken()); // 학교를 연결하는 도로의 개수(1 ≤ M ≤ 10,000)

        university = new boolean[N+1]; // 남초 대학교는 true, 여초 대학교는 false
        parents = new int[N+1];

        String str = br.readLine();
        for(int i = 0; i < N; i++) {
            university[i+1] = str.charAt(i*2) == 'M';
            parents[i+1] = i+1;
        }

        roads = new PriorityQueue<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if(university[from] != university[to]) { // 서로 다른 성별의 학교라면
                roads.add(new Road(from, to, distance));
            }
        }

        int roadCnt = 0;
        while(roadCnt < N-1 && !roads.isEmpty()) {
            Road road = roads.poll();
            int parents1 = findSet(road.from);
            int parents2 = findSet(road.to);

            if(parents1 != parents2) {
                union(parents1, parents2);
                roadCnt++;
                answer += road.distance;
            }
        }

        if(roadCnt < N-1) System.out.println(-1);
        else System.out.println(answer);

    } // end of main

    private static void union(int parents1, int parents2) {
        parents[parents2] = parents1;
    }

    private static int findSet(int university) {
        if(parents[university] != university)
            return parents[university] = findSet(parents[university]);

        return university;
    }

} // end of class
