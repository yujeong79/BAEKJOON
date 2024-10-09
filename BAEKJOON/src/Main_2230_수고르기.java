import java.io.*;
import java.util.*;

public class Main_2230_수고르기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        int answer = Integer.MAX_VALUE;

        int L = 0;
        int R = 1;
        while(L <= R && R < N) {
            if(nums[R] - nums[L] >= M) {
                answer = Math.min(nums[R] - nums[L], answer);
                L++;
            } else {
                R++;
            }
        }

        System.out.println(answer);
    } // end of main
} // end of class
