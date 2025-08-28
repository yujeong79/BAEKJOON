import java.io.*;
import java.util.*;

public class Main {
    public static class Singer {
        int degree;
        List<Integer> edges;

        public Singer() {
            this.degree = 0;
            this.edges = new ArrayList<>();
        };
    }

    public static StringBuilder sb;
    public static int N, M;
    public static Singer[] singers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 가수의 수, 1 <= N <= 1,000
        M = Integer.parseInt(st.nextToken()); // 보조 PD의 수, 1 <= M <= 100

        singers = new Singer[N+1];
        for(int i = 0; i <= N; i++) {
            singers[i] = new Singer();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cnt = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            for(int j = 1; j < cnt; j++) {
                int end = Integer.parseInt(st.nextToken());
                singers[start].edges.add(end);
                singers[end].degree++;
                start = end;
            }
        }

        sb = new StringBuilder();
        if(topologicalSort()) System.out.println(sb.toString());
        else System.out.println(0);
    }

    public static boolean topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            if(singers[i].degree == 0) {
                queue.add(i);
                isVisited[i] = true;
            }
        }

        while(!queue.isEmpty()) {
            int start = queue.poll();
            sb.append(start).append("\n");

            for(int end : singers[start].edges) {
                if(!isVisited[end]) {
                    singers[end].degree--;

                    if(singers[end].degree <= 0) {
                        queue.add(end);
                        isVisited[end] = true;
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            if(!isVisited[i]) {
                return false;
            }
        }

        return true;
    }
}