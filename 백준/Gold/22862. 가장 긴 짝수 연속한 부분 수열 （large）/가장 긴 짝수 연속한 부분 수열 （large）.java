import java.io.*;
import java.util.*;

/*
    길이가 N인 수열 S
    수열 S에서 원하는 위치에 있는 수를 골라 최대 K번 삭제 가능
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 1,000,000
        int K = Integer.parseInt(st.nextToken()); // 1 <= K <= 100,000

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int even = 0;
        int odd = 0;
        int answer = 0;
        while(start <= end && end < N) {
            if(arr[end] % 2 != 0) { // 홀수인 경우
                if(odd >= K) {
                    if (arr[start++] % 2 != 0) odd--;
                    else even--;

                    while(start < N && arr[start] % 2 != 0) {
                        start++;
                        odd--;
                    }
                } else {
                    end++;
                    odd++;
                }
            } else { // 짝수인 경우
                even++; end++;
                answer = Math.max(answer, even);
            }
        }

        System.out.println(answer);
    }
}