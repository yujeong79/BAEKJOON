import java.io.*;
import java.util.*;

public class Main_2805_나무자르기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, maxTree, maxH;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 나무의 수 (1 ≤ N ≤ 1,000,000)
        M = Integer.parseInt(st.nextToken()); // 가져가려고 하는 나무의 길이 (1 ≤ M ≤ 2,000,000,000)

        maxTree = 0; // 최대 나무 높이를 저장
        trees = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxTree = Math.max(maxTree, trees[i]);
        }

        // 절단기의 최소 높이 H를 이분탐색을 통해 찾아보자
        int L = 0;
        int R = maxTree;
        int mid = (L+R)/2;
        while(L <= R && mid <= maxTree) {
            long sum = 0;
            for(int i = 0; i < N; i++) {
                if (trees[i] - mid > 0)
                    sum += trees[i] - mid;
            }
            if(sum >= M) {
                L = mid+1;
                maxH = Math.max(maxH, mid); // 절단기의 최대 높이 업데이트
            }
            else R  = mid-1;

            mid = (L+R)/2;
        }

        System.out.println(maxH);
    } // end of main
} // end of main
