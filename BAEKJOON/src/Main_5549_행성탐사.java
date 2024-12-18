import java.io.*;
import java.util.*;

public class Main_5549_행성탐사 {
    static class Area {
        int Jungle, Ocean, Ice;

        public Area() {}
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int M, N, K;
    static Area[][] map;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // (1 ≤ M, N ≤ 1000)
        M = Integer.parseInt(st.nextToken()); // 세로의 길이
        N = Integer.parseInt(st.nextToken()); // 가로의 길이

        map = new Area[M+1][N+1];
        for(int i = 0; i <= N; i++) {
            map[0][i] = new Area();
        }
        for(int i = 0; i <= M; i++) {
            map[i][0] = new Area();
        }


        K = Integer.parseInt(br.readLine()); // 조사 대상 영역의 개수, (1 ≤ K ≤ 100,000)

        for(int i = 1; i <= M; i++) {
            String str = br.readLine();

            for(int j = 1; j <= N; j++) {
                map[i][j] = new Area();
                map[i][j].Jungle = map[i-1][j].Jungle + map[i][j-1].Jungle - map[i-1][j-1].Jungle;
                map[i][j].Ocean = map[i-1][j].Ocean + map[i][j-1].Ocean - map[i-1][j-1].Ocean;
                map[i][j].Ice = map[i-1][j].Ice + map[i][j-1].Ice - map[i-1][j-1].Ice;

                switch(str.charAt(j-1)) {
                    case 'J':
                        map[i][j].Jungle = map[i-1][j].Jungle + map[i][j-1].Jungle - map[i-1][j-1].Jungle + 1;
                        break;
                    case 'O':
                        map[i][j].Ocean = map[i-1][j].Ocean + map[i][j-1].Ocean - map[i-1][j-1].Ocean + 1;
                        break;
                    case 'I':
                        map[i][j].Ice = map[i-1][j].Ice + map[i][j-1].Ice - map[i-1][j-1].Ice + 1;
                        break;
                }
            }
        }

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int jungle = map[x2][y2].Jungle - map[x1-1][y2].Jungle - map[x2][y1-1].Jungle + map[x1-1][y1-1].Jungle;
            int ocean = map[x2][y2].Ocean - map[x1-1][y2].Ocean - map[x2][y1-1].Ocean + map[x1-1][y1-1].Ocean;
            int ice = map[x2][y2].Ice - map[x1-1][y2].Ice - map[x2][y1-1].Ice + map[x1-1][y1-1].Ice;

            sb.append(jungle).append(" ").append(ocean).append(" ").append(ice).append("\n");
        }

        System.out.println(sb);

    } // end of main
} // end of class
