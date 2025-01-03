import java.io.*;
import java.util.*;

// 1644번 소수의 연속합 Gold3

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static boolean[] isCombine;
    static ArrayList<Long> primeNums;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // (1 ≤ N ≤ 4,000,000)

        primeNums = new ArrayList<>(); primeNums.add(0L);
        isCombine = new boolean[N+1];
        isCombine[0] = isCombine[1] = true;

        for(int num = 2; num <= N; num++) {
            if(!isCombine[num]) {
                int pSize = primeNums.size();
                primeNums.add(primeNums.get(pSize-1) + (long)num);

                int i = 1;
                while(num * i <= N) {
                    isCombine[num*i] = true;
                    ++i;
                }
            }
        }

//        System.out.println(primeNums.toString());

        int end = primeNums.size() - 1; // primeNums.get(end) < N 이면 종료
        int start = end - 1; // primeNums.get(end) - primeNums.get(start) > N이면 종료
        int ans = 0;

        while(primeNums.get(end) >= N) {
            if(primeNums.get(end) - primeNums.get(start) == N) {
                ans++;
                end--;
                start = end - 1;
            }
            else if(primeNums.get(end) - primeNums.get(start) < N) {
                start--;
            }
            else {
                end--;
                start = end - 1;
            }
        }

        System.out.println(ans);

    } // end of main
} // end of class