import java.io.*;
import java.util.*;

/*
    1번. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
    2번. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동한다.
        - 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 내구도가 1 이상이어야 한다.
        - 이동할 수 없다면 가만히 있는다.
    3번. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
    4번. 내구도가 0인 칸의 개수가 K개 이상이라면 종료한다.
 */

public class Main {
    static class Robot {
        int idx;

        public Robot(int idx) {
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 2 ≤ N ≤ 100
        int K = Integer.parseInt(st.nextToken()); // 1 ≤ K ≤ 2N

        int doubleN = 2*N;
        int[] conveyor = new int[doubleN];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < doubleN; i++) {
            conveyor[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Robot> robots = new LinkedList<>();
        boolean[] hasRobot = new boolean[doubleN];

        int start = 0;
        int end = N-1;
        int count = 0;
        int level = 0;
        while(count < K) {
            level++; // 단계

            // 벨트 한 칸 회전
            start = (start+doubleN-1) % doubleN;
            end = (end+doubleN-1) % doubleN;

            // 벨트가 회전하여 내리는 위치에 로봇이 도달하면 그 즉시 하차
            if(!robots.isEmpty() && robots.peek().idx == end) {
                robots.poll();
                hasRobot[end] = false;
            }

            for(Robot robot : robots) {
                int nextIdx = (robot.idx+1)%doubleN;
                if(conveyor[nextIdx] > 0 && !hasRobot[nextIdx]) { // 다음 칸이 내구도가 1 이상이고 로봇이 없다면
                    hasRobot[robot.idx] = false;

                    robot.idx = nextIdx; // 로봇 이동
                    hasRobot[robot.idx] = true;
                    conveyor[robot.idx]--; // 내구도 1 감소
                    if(conveyor[robot.idx] <= 0) count++; // 내구도가 0 이하라면 count 1 증가

                    // 내리는 위치에 로봇이 도달하면 즉시 하차
                    if(robots.peek().idx == end) {
                        hasRobot[end] = false;
                    }
                }
            }

            while(!robots.isEmpty() && robots.peek().idx == end) {
                robots.poll();
            }

            // 올리는 위치의 내구도가 1 이상인 경우 로봇 올리기
            if(conveyor[start] > 0) {
                conveyor[start]--;
                hasRobot[start] = true;
                robots.add(new Robot(start));

                if(conveyor[start] <= 0) count++; // 내구도가 0 이하라면 count 1 증가
            }
        }

        System.out.println(level);

    }
}