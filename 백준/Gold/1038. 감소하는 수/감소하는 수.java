import java.io.*;
import java.util.*;

/*
    작은 수부터 구하기 위해서는 현재 자리가 9까지 가면 하는걸로 되어야하는데
    그런데 이건 완전 탐색 아닌가?
    이걸... 백트래킹으로..?
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //  1 <= N <= 1,000,000
        long[] nums = new long[N+1];
        Arrays.fill(nums, -1);

        // 초기화
        for(int i = 0; i <= 9; i++) {
            if(N >= i) nums[i] = i;
        }

        int target = 1;
        int idx = 10;
        while(idx <= N && target < idx) {
            for(int i = 0; i <= 9 && idx <= N; i++) {
                if(nums[target]%10 > i) {
                    nums[idx++] = nums[target]*10+i;
                }
            }

            target++;
        }
        
        System.out.println(nums[N]);
    }
}