import java.io.*;
import java.util.*;

/**
 * N개의 동전이 주어질 때, K원을 만드는데 필요한 동전 개수의 최솟값을 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       StringTokenizer st = new StringTokenizer(br.readLine(), " ");
       int N = Integer.parseInt(st.nextToken()); // (1 ≤ N ≤ 10)
       int K = Integer.parseInt(st.nextToken()); // (1 ≤ K ≤ 100,000,000)
       
       int[] coins = new int[N];
       
       int idx = 0;
       for(int i = 0; i < N; i++) { // (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
    	   coins[i] = Integer.parseInt(br.readLine());
    	   
    	   if(coins[i] <= K) {
    		   idx = i;
    	   }
       }
       
       int ans = 0;
       while(K >= 1) {
    	   int curr = coins[idx--];
    	   
    	   if(K >= curr) {
    		   ans += K / curr;
    		   K %= curr;
    	   }
       }
       
       System.out.println(ans);
       
    }
}