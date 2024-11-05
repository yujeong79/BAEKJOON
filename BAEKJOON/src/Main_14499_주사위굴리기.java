import java.io.*;
import java.util.*;

public class Main_14499_주사위굴리기 {
    static class Dice {
        int north = 2;
        int top = 1;
        int south = 5;
        int bottom = 6;
        int east = 3;
        int west = 4;

        public Dice() {
        }

        @Override
        public String toString() {
            return "Dice{" +
                    "north=" + north +
                    ", top=" + top +
                    ", south=" + south +
                    ", bottom=" + bottom +
                    ", east=" + east +
                    ", west=" + west +
                    '}';
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, x, y, K;
    static int[][] map;
    static int[] side;
    static Dice dice;

    public static void init() {
        map = new int[N][M];
        side = new int[7]; // 1~6 인덱스에 주사위의 각 면에 적힌 수를 저장
        dice = new Dice();
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 지도의 세로 크기
        M = Integer.parseInt(st.nextToken()); // 지도의 가로 크기
        x = Integer.parseInt(st.nextToken()); // 주사위의 좌표 (x, y)
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 명령의 개수

        init();

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j*2) - '0'; // 10 미만의 자연수 또는 0
            }
        }

        String str = br.readLine();
        for(int i = 0; i < K; i++) {
            moveDice(str.charAt(i*2) - '0');
        }

        System.out.println(sb);

    } // end of main

    // 1:동, 2:서, 3:북, 4:남
    private static final int[][] dir = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    private static void moveDice(int d) {
    	int nx = x + dir[d][0];
        int ny = y + dir[d][1];

        if(nx >= 0 && nx < N && ny >= 0 && ny < M) { // 지도 범위 내에 있으면 주사위를 굴리기
            x = nx; y = ny;
            rollDice(d); // 주사위 굴리기
            
            if(map[x][y] == 0) {
                map[x][y] = side[dice.bottom]; // 주사위의 바닥면에 쓰여 있는 수가 헤당 좌표에 복사된다.
            } else {
                side[dice.bottom] = map[x][y]; // 해당 좌표에 적혀 있는 수가 주사위의 바닥면에 복사된다.
                map[x][y] = 0; // 해당 좌표는 0이 된다.
            }
            
//            System.out.println("(" + x + ", " + y + ")");
//            System.out.println(dice);
//            System.out.println(Arrays.toString(side));

            sb.append(side[dice.top]).append("\n");
        }
    }

    private static void rollDice(int d) {
        switch(d) {
            case(1): // 동쪽으로 굴리기
                int tempWest = dice.west;

                dice.west = dice.bottom;
                dice.bottom = dice.east;
                dice.east = dice.top;
                dice.top = tempWest;
                break;
            case(2): // 서쪽으로 굴리기
                int tempEast = dice.east;

                dice.east = dice.bottom;
                dice.bottom = dice.west;
                dice.west = dice.top;
                dice.top = tempEast;
                break;
            case(3): // 북쪽으로 굴리기
                int tempSouth = dice.south;

                dice.south = dice.bottom;
                dice.bottom = dice.north;
                dice.north = dice.top;
                dice.top = tempSouth;
                break;
            case(4): // 남쪽으로 굴리기
                int tempNorth = dice.north;

                dice.north = dice.bottom;
                dice.bottom = dice.south;
                dice.south = dice.top;
                dice.top = tempNorth;
                break;
        }
    }

} // end of class

/**
 * 반례
3 5 1 2 30
6 7 3 1 4
4 8 0 5 8
1 2 9 6 2
3 4 1 2 2 2 1 4 3 4 1 3 4 3 3 2 4 2 2 4 2 4 2 1 3 1 3 3 4 1

답
0 
0
0
0
5
0 * 여기가 틀림
5
3
5
3
4
5
4
5
9
3
5
4
7
5
4
1
2
1
8
 */
