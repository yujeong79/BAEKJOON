import java.io.*;
import java.util.*;

public class Main_BAEKJOON_21608_상어초등학교_Gold5_252ms {
	static class Point implements Comparable<Point> { // 자리 클래스, 가능한 자리를 저장하는 리스트에 Point를 저장
		int r, c, friends, empty;

		public Point(int r, int c, int friends, int empty) {
			this.r = r;
			this.c = c;
			this.friends = friends; // 인접한 자리 중 좋아하는 친구의 수
			this.empty = empty; // 인접한 자리 중 비어있는 자리의 수
		}

		@Override
		public int compareTo(Point o) { // 앉을 수 있는 자리가 2개 이상일 때 정렬을 하기 위함
			if(this.empty == o.empty && this.r == o.r) return this.c - o.c; // 빈자리 수도 같고, 행의 번호도 같다면 열의 번호가 작은 순대로 오름차순 정렬
			if(this.empty == o.empty) return this.r - o.r; // 빈자리 수가 같다면 행의 번호가 작은 순대로 오름차순 정렬
			return o.empty - this.empty; // 기본적으로 빈자리가 많은 순대로 내림차순 정렬
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int N;
	static Map<Integer, List<Integer>> students = new LinkedHashMap<>(); // 학생과 해당 학생이 좋아하는 친구들을 저장하기 위한 맵, 순서대로 받기 위해 LinkedHashMap 사용 
	private static ArrayList<Point> possibleSeat = new ArrayList<>(); // 해당 학생이 앉을 수 있는 자리를 저장하기 위한 리스트
	static int[][] classroom; // 학생들의 자리를 저장하기 위한 2차원 배열
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		classroom = new int[N][N];
		
		for(int i = 0; i < N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int student = Integer.parseInt(st.nextToken());
			List<Integer> favoriteFriends = new ArrayList<>();
			
			for(int j = 0; j < 4; j++) {
				favoriteFriends.add(Integer.parseInt(st.nextToken()));
			}
			students.put(student, favoriteFriends);
		} // 입력 완료
		
		
		for(int s : students.keySet()) { // 입력받은 학생 순서대로
			if(!condition1(s)) // 조건1을 수행하는 메소드
				condition2(s); // 조건2와 3을 수행하는 메소드
		} // 자리 배치 완료
		
		int total = 0; // 만족도 총합
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int s = classroom[i][j]; // 해당 자리의 학생
				int cnt = 0; // 해당 학생의 인접한 자리 중 좋아하는 학생의 수
				
				for(int d = 0; d < 4; d++) { // 인접한 칸을 탐색하며
					int r = i + dir[d][0];
					int c = j + dir[d][1];
					if(r >= 0 && r < N && c >= 0 && c < N) {
						if(students.get(s).contains(classroom[r][c])) cnt++; // 좋아하는 학생이 있으면 cnt 1 증가
					}
				}
				
				switch(cnt) { // 만족도 계산
				case(0): total += 0; break;
				case(1): total += 1; break;
				case(2): total += 10; break;
				case(3): total += 100; break;
				case(4): total += 1000; break;
				}
			}
		}
		
		System.out.println(total);
		
	} // end of main

	private static void condition2(int student) {
		Collections.sort(possibleSeat); // 가능한 자리를 빈자리 수 -> 행의 번호 -> 열의 번호 순대로 정렬

		classroom[possibleSeat.get(0).r][possibleSeat.get(0).c] = student; // 조건에 다 부합하는 자리에 학생 배치
		
		return;
				
	}

	private static boolean condition1(int student) {
		possibleSeat.clear(); // student가 가능한 자리를 저장할 리스트
		
		int maxCnt = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int favoriteFriendsCnt = 0; // 인접한 칸에 위치한 좋아하는 친구들의 수를 세기 위한 변수
				int emptyCnt = 0; // 해당 자리 주위로 비어있는 칸의 수를 세기 위한 변수
				
				if(classroom[i][j] == 0) {
					for(int d = 0; d < 4; d++) { // 인접한 칸을 탐색하며
						int r = i + dir[d][0];
						int c = j + dir[d][1];
						if(r >= 0 && r < N && c >= 0 && c < N) {
							if(students.get(student).contains(classroom[r][c])) { // 좋아하는 친구 리스트에 있으면
								favoriteFriendsCnt++;
							} else if(classroom[r][c] == 0){ // 빈자리이면
								emptyCnt++;
							}
						}
					}
					
					if(maxCnt < favoriteFriendsCnt) { // 기존의 좋아하는 친구 수가 가장 많은 자리보다 해당 자리가 더 많다면
						maxCnt = favoriteFriendsCnt; // maxCnt 업데이트하고
						
						possibleSeat.clear(); // 기존의 가능한 자리 비우고
						possibleSeat.add(new Point(i, j, favoriteFriendsCnt, emptyCnt)); // 새로운 자리 넣기
					} else if(maxCnt == favoriteFriendsCnt) { // 좋아하는 친구 수가 같다면
						possibleSeat.add(new Point(i, j, favoriteFriendsCnt, emptyCnt)); // 기존 리스트에 자리 넣기					
					}
					
				}
				
				
			}
		}
		
		if(possibleSeat.size() == 1) { // 앉을 수 있는 자리가 하나라면 그곳으로 자리를 지정
			classroom[possibleSeat.get(0).r][possibleSeat.get(0).c] = student;
			
			return true;
		}
		
		return false;
		
	}
	
} // end of class
