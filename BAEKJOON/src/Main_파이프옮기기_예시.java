import java.io.*;
import java.util.*;

public class Main_파이프옮기기_예시 {
	static int N; // 맵 크기
    static int[][] map; // 전체 맵
    static int cnt = 0; // 경로의 수
    
    static int Row = 0;
    static int Col = 1;
    static int Dia = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 상태: 가로 방향으로 (0, 0)에서 (0, 1)로 시작
        move(0, 1, Row);

        System.out.print(cnt);
    }

    private static void move(int row, int col, int status) {
        // 기저 조건
        if (row == N - 1 && col == N - 1) {
            cnt++;
            return;
        }

        if (row >= N || col >= N) {
            return;
        }

        if (status == Row || status == Dia) {
            if (col + 1 < N && map[row][col + 1] == 0) { // 세로가 범위 내 and 1이 아니면
                move(row, col + 1, Row);
            }
        }

        if (status == Col || status == Dia) {
            if (row + 1 < N && map[row + 1][col] == 0) {// 가로가 범위 내 and 1이 아니면
                move(row + 1, col, Col);
            }
        }

        if (col + 1 < N && row + 1 < N && map[row][col + 1] == 0 && map[row + 1][col] == 0
                && map[row + 1][col + 1] == 0) {
            move(row + 1, col + 1, Dia);
        } // 대각이 범위 내 and 1이 아니면
    }
}