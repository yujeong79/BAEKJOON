import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2580 {

    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");

            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0);
    }

    static void backTracking(int x, int y) {

        // y가 9가 되면 다음 row로 재귀함수 호출
        if (y > 8) {
            backTracking(x + 1, 0);
            return;
        }

        // 모든 row에 대해 스도쿠를 풀면 출력 후 종료
        // 한 개의 스도쿠판만 출력해야하므로 exit를 통해 강제종료함
        if (x > 8) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        // 스도쿠 칸이 비어있으면(즉 0일 경우에)
        if (map[x][y] == 0) {
            for (int i = 1; i <= 9; i++) { // 1 ~ 9 숫자에 대해 유효성 체크
                if (checkMap(x, y, i)) {
                    map[x][y] = i; // 현재 시점에서 스도쿠판에 i를 넣을 수 있으면 map[x][y] = i
                    backTracking(x, y + 1); // 다음 칸으로 재귀함수 호출
                }
            }
            // 스도쿠를 채워나가면서 계속 값이 바뀌는데 위 반복문으로 맞는 값을 찾을 수 없는 경우
            // 즉 마지막 map[x][y]에 들어간 값이 3인데, 재귀함수를 계속 타고가면서
            // 3 이후값이 아니라 1, 2같은 이전값이 들어가야 맞는 경우에는
            // 반복문을 처음부터 다시 돌리지 않는한 이전값인 1,2가 나올 수 없다.
            // 그러므로 map[x][y]를 0으로 만들고 return하여 이전 빈칸부터 재귀함수를 다시 호출한다.
            map[x][y] = 0;
            return;
        }

        backTracking(x, y + 1);
    }

    // 노드가 유망한지 체크
    static boolean checkMap(int x, int y, int value) {

        // row check (해당 행의 중복성 체크)
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == value)
                return false;
        }

        // col check (해당 열의 중복성 체크)
        for (int j = 0; j < 9; j++) {
            if (map[j][y] == value) {
                return false;
            }
        }

        // square (근처 3 * 3에 대해 중복성 체크)
        int sx = x / 3 * 3;
        int sy = y / 3 * 3;

        for (int i = sx; i < sx + 3; i++) {
            for (int j = sy; j < sy + 3; j++) {
                if (map[i][j] == value)
                    return false;
            }
        }

        return true;
    }
}