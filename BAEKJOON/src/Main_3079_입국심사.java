import java.io.*;
import java.util.*;

public class Main_3079_입국심사 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static long answer;
    static int[] T;

    public static void init() {
        T = new int[N];
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // (1 ≤ N ≤ 100,000, 1 ≤ M ≤ 1,000,000,000)
        N = Integer.parseInt(st.nextToken()); // 입국 심사대의 수
        M = Integer.parseInt(st.nextToken()); // 상근이와 친구들의 수

        init();

        for(int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(br.readLine()); // (1 ≤ Tk ≤ 10^9)
        }

        Arrays.sort(T); // 입국 심사가 빠른 순서대로 오름차순 정렬

        binarySearch();

        System.out.println(answer);

    } // end of main

    public static void binarySearch() {
        long start = 0;
        long end = (long) (M/N+1) * T[N-1]; // M % N > 0 인 경우를 고려하여 M/N한 값에 1을 더한 뒤 제일 오래 걸리는 시간을 곱해준다.

        while(start <= end) {
            long mid = (start + end) / 2;

            if(isPossible(mid)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }

    public static boolean isPossible(long mid) {
        long passedCnt = 0;

        for(int t : T) {
            passedCnt += mid/t;

            if(passedCnt >= M)
                return true;
        }

        return false;
    }

} // end of class
