import java.io.*;
import java.util.*;

/**
 * [풀이]
 * 거리를 기준으로 이분탐색하자.
 * min을 이웃한 집 중 그 거리가 가장 짧은 값으로, max를 집 간의 거리가 가장 먼 값으로 설정한다.
 * 
 */
public class Main_2110_공유기설치 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, C, min, max;
    static int[] house;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 집의 개수, (2 ≤ N ≤ 200,000)
        C = Integer.parseInt(st.nextToken()); // 공유기의 개수, (2 ≤ C ≤ N)
        
        house = new int[N];
        for(int i = 0; i < N; i++) {
        	house[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(house); // 집의 좌표를 오름차순으로 정렬
        
        max = house[N-1] - house[0]; // 좌표의 최댓값과 최솟값의 차이를 max로 설정
        min = Integer.MAX_VALUE;
        for(int i = 0; i < N-1; i++) { // 이웃한 집 간의 거리가 가장 짧은 값을 min으로 설정
        	min = Math.min(house[i+1] - house[i], min);
        } // 그런데 min을 굳이 이렇게까지 찾아야할까? 일단 해보자.
        
        
        System.out.println(max + ", " + min);

    } // end of main
} // end of class
