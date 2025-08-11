import java.io.*;
import java.util.*;

public class Main {
    static class Cell {
        int durability;
        boolean hasRobot;

        public Cell(int durability) {
            this.durability = durability;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 2 ≤ N ≤ 100
        int K = Integer.parseInt(st.nextToken()); // 1 ≤ K ≤ 2N

        int doubleN = 2*N;
        Cell[] conveyor = new Cell[doubleN];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < doubleN; i++) {
            conveyor[i] = new Cell(Integer.parseInt(st.nextToken()));
        }

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
            if(conveyor[end].hasRobot) {
                conveyor[end].hasRobot = false;
            }

            int currRobot = end > 0 ? end-1 : doubleN-1;
            while(true) {
                if(!conveyor[currRobot].hasRobot) {
                    if(currRobot == start) break;

                    if(currRobot-1 < 0) currRobot = doubleN-1;
                    else currRobot--;

                    continue;
                }

                int nextIdx = (currRobot+1) % doubleN;
                if(conveyor[nextIdx].durability > 0 && !conveyor[nextIdx].hasRobot) { // 다음 칸이 내구도가 1 이상이고 로봇이 없다면
                    conveyor[currRobot].hasRobot = false;
                    conveyor[nextIdx].hasRobot = true;
                    conveyor[nextIdx].durability--; // 내구성 1 감소

                    if(conveyor[nextIdx].durability <= 0) count++; // 내구도가 0 이하라면 count 1 증가
                    if(nextIdx == end) conveyor[nextIdx].hasRobot = false; // 내리는 위치에 로봇이 도달하면 즉시 하차
                }

                if(currRobot == start) break;

                if(currRobot-1 < 0) currRobot = doubleN-1;
                else currRobot--;
            }

            // 올리는 위치의 내구도가 1 이상인 경우 로봇 올리기
            if(conveyor[start].durability > 0) {
                conveyor[start].durability--;
                conveyor[start].hasRobot = true;

                if(conveyor[start].durability <= 0) count++; // 내구도가 0 이하라면 count 1 증가
            }
        }

        System.out.println(level);

    }
}