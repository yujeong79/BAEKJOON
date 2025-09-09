import java.io.*;
import java.util.*;

/**
 * [풀이]
 * 거리를 기준으로 이분탐색하자.
 * min을 이웃한 집 중 그 거리가 가장 짧은 값으로, max를 집 간의 거리가 가장 먼 값으로 설정한다.
 * 
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, C, min, max, answer;
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
        min = 0;
        
        while(min <= max) {
        	int mid = (min + max)/2;
        	
        	if(isPossible(mid)) {
        		answer = mid;
        		min = mid + 1;
        	}
        	else {
        		max = mid - 1;
        	}
        }
        
        System.out.println(answer);

    } // end of main
    
	private static boolean isPossible(int dist) {
		int selectedHouse = 1; // 공유기를 설치한 집의 수
		int h1 = 0; // 공유기를 설치한 집의 인덱스
		int h2 = 1; // 공유기를 설치할 다음 집의 인덱스
		
		while(selectedHouse < C && h2 <= N-1) {
			if(house[h2] - house[h1] >= dist) {
				h1 = h2;
				selectedHouse++;
				if(selectedHouse == C) return true;
			}
			
			h2 += 1; // 한 칸 이동
		}
		
		return false;
	}
	
} // end of class