import java.io.*;
import java.util.*;

public class Main_1005_ACMCraft {
    static class Building {
        int num, time;

        public Building(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, K, W;
    static int[] buildings, degree, wholeTime;
    static int[][] adjArr;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // 건물의 수
            K = Integer.parseInt(st.nextToken()); // 건물 간의 건설 순서 규칙의 총 개수

            buildings = new int[N+1];
            wholeTime = new int[N+1];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i <= N; i++) {
                buildings[i] = Integer.parseInt(st.nextToken());
                wholeTime[i] = buildings[i];
            }

            adjArr = new int[N+1][N+1];
            degree = new int[N+1];

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                adjArr[from][to] = 1;
                degree[to]++;
            }

            W = Integer.parseInt(br.readLine()); // 최종적으로 건설해야하는 건물의 번호

            Queue<Building> queue = new LinkedList<>();

            for(int i = 1; i <= N; i++) {
                if(degree[i] == 0) {
                    queue.add(new Building(i, buildings[i]));
                }
            }

            while(!queue.isEmpty()) {
                Building curr = queue.poll();

                if(curr.num == W) {
                    break;
                }

                for(int i = 1; i <= N; i++) {
                    if(adjArr[curr.num][i] == 1) {
                        degree[i]--;
                        adjArr[curr.num][i] = 0;

                        wholeTime[i] = Math.max(wholeTime[i], curr.time + buildings[i]);

                        if(degree[i] == 0) {
                            queue.add(new Building(i, wholeTime[i]));
                        }
                    }
                }
            }

            sb.append(wholeTime[W]).append("\n");

        } // end of testcase

        System.out.println(sb);

    } // end of main
} // end of class
