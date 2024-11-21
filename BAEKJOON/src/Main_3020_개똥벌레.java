import java.io.*;
import java.util.*;

/**
 * 출력 
 * - 장애물의 최솟값과 그러한 구간의 수를 공백으로 구분하여 출력
 * - 개똥벌레가 파괴해야하는 장애물의 최솟값에 부합하는 구간의 총 수
 * 
 * 이분탐색 기준
 * 방법1.
 * - 장애물의 수를 이분탐색?
 * - 구간마다 파괴해야하는 장애물의 수를 저장해놓고 탐색해보자
 * - 그러면 장애물의 수를 이분탐색할 때마다 모든 구간을 탐색해야하잖아? => 상당히 비효율적
 * 
 * 방법2.
 * - 그러면 최소 장애물 수를 찾아놓고 딱 한 번만 해당 최소 장애물 수를 가진 구간을 이분탐색을 찾는건가?
 * - 
 */

public class Main_3020_개똥벌레 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, H;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 동굴의 길이, (2 ≤ N ≤ 200,000)
		H = Integer.parseInt(st.nextToken()); // 동굴의 높이, (2 ≤ H ≤ 500,000)
		
	} // end of main
} // end of class
