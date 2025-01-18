import java.io.*;
import java.util.*;

/**	
 * 치킨집의 개수가 M개가 될 때까지 백트래킹으로 치킨집을 폐업시키고 도시의 치킨 거리의 최솟값을 업데이트 한다.	
 */

public class Main {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, store, min;
	static char[][] map;
	static List<Point> storeLocationList;
 	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N  = Integer.parseInt(st.nextToken()); // 도시의 크기
		M  = Integer.parseInt(st.nextToken()); // 치킨집의 최대 개수
		
		// 초기화 작업
		storeLocationList = new ArrayList<>();
		min = Integer.MAX_VALUE;
		store = 0;
		map = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0, idx = 0; j < N; j++, idx+=2) {
				map[i][j] = str.charAt(idx);
				if(map[i][j] == '2') store++; // 현재 치킨집의 개수 세기
			}
		}
		
		demolishStore(0, store);
		
		System.out.println(min);
		
	} // end of main

	private static void demolishStore(int currentLocation, int cnt) {
		if(cnt == M) { // 현재 치킨집의 수와 치킨집의 최대 개수가 같으면 종료
			getAllDistance(cnt); // 현재 상태에서 도시의 치킨 거리 구하기
			return;
		}
		
		if(currentLocation == N*N) { // 모든 칸을 탐색했으면 종료
			return;
		}
		
		int r = currentLocation / N;
		int c = currentLocation % N;
		if(map[r][c] == '2') { // 현재 위치에 치킨집이 있으면
			map[r][c] = '0'; // 치킨집 철거
			demolishStore(currentLocation+1, cnt-1);
			map[r][c] = '2'; // 원상복구
		}
		demolishStore(currentLocation+1, cnt);
	}

	private static void getAllDistance(int cnt) {
		int allDistance = 0;
		
		storeLocationList.clear();
		for(int i = 0; i < N; i++) { // map을 순회하면서 치킨집의 위치를 list에 담기
			for(int j = 0; j < N; j++) {
				if(map[i][j] == '2') {
					storeLocationList.add(new Point(i, j));
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == '1') {
					int distance = Integer.MAX_VALUE;
					for(int s = 0; s < cnt; s++) {
						distance = Math.min(Math.abs(storeLocationList.get(s).r - i) + Math.abs(storeLocationList.get(s).c - j), distance); 
					}
					allDistance += distance;
				}
			}
		}
		
		min = Math.min(min, allDistance);
	}
	
	
} // end of class