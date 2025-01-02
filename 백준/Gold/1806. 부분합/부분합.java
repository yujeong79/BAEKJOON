import java.io.*;
import java.util.*;

// 1806번 부분합 Gold4

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, S;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 수열의 길이, (10 ≤ N < 100,000)
        S = Integer.parseInt(st.nextToken()); // 부분합이 S 이상이 되도록 (0 < S ≤ 100,000,000)

        nums = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch());

    } // end of main

    private static int binarySearch() {
        int ans = 0;

        int start = 0;
        int end = N;

        while(start <= end) {
            int mid = (start+end)/2;

            boolean flag = false;
            for(int i = mid; i <= N; i++) {
                if(nums[i] - nums[i-mid] >= S) {
                    ans = mid;
                    end = mid - 1;
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                start = mid + 1;
            }
        }

        return ans;
    }

} // end of class