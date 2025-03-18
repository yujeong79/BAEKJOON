import java.io.*;
import java.util.*;

/**
 * 각 회의 I에 대해 시작 시간과 끝나는 시간이 주어질 때 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 구하기
 * - 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있음
 * - 회의의 시작 시간과 끝나는 시간이 같을 수도 있음
 */

public class Main {
    static class Meeting implements Comparable<Meeting> {
        int startTime, endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Meeting other) {
            if (this.endTime == other.endTime) {
                return this.startTime - other.startTime;
            }

            return this.endTime - other.endTime;
        }

        @Override
        public String toString() {
            return startTime + " ~ " + endTime;
        }
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // (1 ≤ N ≤ 100,000)

        Meeting[] meetings = new Meeting[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            meetings[i] = new Meeting(startTime, endTime);
        }

        Arrays.sort(meetings);
//        System.out.println(Arrays.toString(meetings));

        int[] dp = new int[meetings[N-1].endTime + 1];
        for(int i = 0; i < N; i++) {
            dp[meetings[i].endTime] = Math.max(dp[meetings[i].startTime] + 1, dp[meetings[i].endTime-1]);

            int currIdx = meetings[i].endTime;
            while(i < N-1 && currIdx < meetings[i+1].endTime) {
                dp[++currIdx] = dp[meetings[i].endTime];
            }
        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[meetings[N-1].endTime]);

    }
}