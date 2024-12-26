import java.io.*;
import java.util.*;

// 20444번 색종이와 가위 Gold5

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long N;
    static long K;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Long.parseLong(st.nextToken()); // 1 ≤ N ≤ 2^31-1(Integer.MAX_VALUE)
        K = Long.parseLong(st.nextToken()); // 1 ≤ K ≤ 2^63-1

        System.out.println(binarySearch());

    } // end of main

    private static String binarySearch() {
        long start = 1;
        long end = (N + 2)/2;

        while(start <= end) {
            long mid = (start+end)/2;
            long mul = mid * (N+2-mid);

            if(mul == K) return "YES";

            if(mul > K) end = mid - 1;
            else start = mid + 1;
        }

        return "NO";
    }

} // end of class