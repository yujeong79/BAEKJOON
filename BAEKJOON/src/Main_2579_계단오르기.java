import java.io.*;
import java.util.*;

/**
 * [n-1]이 true(수)이고 [n-2]가 false(0)라면 true/false 둘 다 가능
 * [n-1]이 false -> [n]은 무조건 true
 * [n-2][n-2]가 둘 다 true -> [n]은 무조건 false
 */
public class Main_2579_계단오르기 {
	static class Stair {
		int score;
		List<Boolean> isVisited;
		
		public Stair(int score, List<Boolean> isVisited) {
			this.score = score;
			this.isVisited = isVisited;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, maxScore;
	static int[] stairs;
	static List<Stair> dp;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 계단의 수
		
		stairs = new int[N+1];
		for(int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new ArrayList<>(); // 현재 층까지 오를 수 있는 계단의 조합과 점수를 저장
		
		// 시작점에서 계단을 오르는 두 가지 경우를 저장
		List<Boolean> visitedFirstFloor = new ArrayList<>(); // 시작에서 한 계단 오르는 경우
		visitedFirstFloor.add(true);
		visitedFirstFloor.add(true);
		dp.add(new Stair(10, visitedFirstFloor));
		
		List<Boolean> notVisitedFirstFloor = new ArrayList<>(); // 시작에서 두 계단을 오르는 경우
		notVisitedFirstFloor.add(true);
		notVisitedFirstFloor.add(false);
		dp.add(new Stair(0, notVisitedFirstFloor));
		
		maxScore = 0;
		
		for(int i = 2; i <= N; i++) { // 2층에서부터 N층까지 층별로 가능한 점수를 구해보자
			int size = dp.size();
			
			for(int j = 0; j < size; j++) { // 현재 dp에 저장되어 있는 가능한 계단의 조합을 모두 보면서
				List<Boolean> list = dp.get(j).isVisited;
				
				if(list.get(i-1) && !list.get(i-2)) { 
					dp.get(j).score += stairs[i];
					dp.get(j).isVisited.add(true);
					
					// false도 dp에 마지막에 넣기
					List<Boolean> falseList = new ArrayList<>(list);
					falseList.add(false);
					dp.add(new Stair(dp.get(j).score, falseList));
					
				} else if(!list.get(i-1)) {
					dp.get(j).score += stairs[i];
					dp.get(j).isVisited.add(true);
				} else if(list.get(i-1) && list.get(i-2)){
					dp.get(j).isVisited.add(false);
				}
				
				if(i == N) { // 마지막층이라면 점수의 최댓값 찾아보기
					maxScore = Math.max(maxScore, dp.get(j).score);
				}
				
			}
		}
		
		System.out.println(maxScore);
		
	} // end of main
} // end of class
