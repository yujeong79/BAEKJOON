import java.io.*;
import java.util.*;

// 2042번 구간 합 구하기 Gold1

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    static long[] nums;
    static long[] segTree;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // N개의 수 (1 ≤ N ≤ 1,000,000)
        M = Integer.parseInt(st.nextToken()); // 변경이 일어나는 횟수 (1 ≤ M ≤ 10,000)
        K = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수 (1 ≤ K ≤ 10,000)

        nums = new long[N+1];
        for(int i = 1; i <= N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        segTree = new long[N*4];
        makeSegTree(1, 1, N);

        int Q = M + K;
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String query = st.nextToken();
            switch(query) {
                case("1"):
                    int target = Integer.parseInt(st.nextToken());
                    long updateNum = Long.parseLong(st.nextToken());
                    updateSegTree(1, 1, N, target, updateNum);
                    break;
                case("2"):
                    int targetStart = Integer.parseInt(st.nextToken());
                    int targetEnd = Integer.parseInt(st.nextToken());
                    sb.append(findSegTree(1, 1, N, targetStart, targetEnd)).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    } // end of main

    private static long makeSegTree(int idx, int currStart, int currEnd) {
        if(currStart > N) return 0;

        if(currStart == currEnd) {
            segTree[idx] = nums[currStart];
            return segTree[idx];
        }

        int mid = (currStart+currEnd) / 2;
        long left = makeSegTree(idx*2, currStart, mid);
        long right = makeSegTree(idx*2+1, mid+1, currEnd);

        segTree[idx] = left + right;
        return segTree[idx];
    }

    private static long updateSegTree(int idx, int currStart, int currEnd, int target, long updateNum) {
        if(currStart == target && currEnd == target) {
            nums[target] = updateNum;
            return segTree[idx] = nums[target];
        }

        if(currStart > target || currEnd < target) return segTree[idx];

        int mid = (currStart+currEnd) / 2;
        long left = updateSegTree(idx*2, currStart, mid, target, updateNum);
        long right = updateSegTree(idx*2+1, mid+1, currEnd, target, updateNum);

        return segTree[idx] = left + right;
    }

    private static long findSegTree(int idx, int currStart, int currEnd, int targetStart, int targetEnd) {
        if(currStart >= targetStart && currEnd <= targetEnd) return segTree[idx];

        if(currStart > targetEnd || currEnd < targetStart) return 0;

        int mid = (currStart+currEnd) / 2;
        long left = findSegTree(idx*2, currStart, mid, targetStart, targetEnd);
        long right = findSegTree(idx*2+1, mid+1, currEnd, targetStart, targetEnd);

        return left+right;
    }
} // end of class