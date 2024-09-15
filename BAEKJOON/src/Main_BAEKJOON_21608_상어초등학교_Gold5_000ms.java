import java.io.*;
import java.util.*;

public class Main_BAEKJOON_21608_상어초등학교_Gold5_000ms {
	static class Point implements Comparable<Point> {
		int r, c, friends, empty;

		public Point(int r, int c, int friends, int empty) {
			this.r = r;
			this.c = c;
			this.friends = friends;
			this.empty = empty;
		}

		@Override
		public String toString() {
			return "[Point (" + r + ", " + c + ") friends=" + friends + ", empty=" + empty + "]";
		}

		@Override
		public int compareTo(Point o) {
			if(this.empty == o.empty && this.r == o.r) return this.r - o.r;
			if(this.empty == o.empty) return this.r - o.r;
			return o.empty - this.empty;
			
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int N;
	static Map<Integer, List<Integer>> students = new LinkedHashMap<>();
	static int[][] classroom;
	private static ArrayList<Point> possibleSeat = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int student = Integer.parseInt(st.nextToken());
			List<Integer> favoriteFriends = new ArrayList<>();
			
			for(int j = 0; j < 4; j++) {
				favoriteFriends.add(Integer.parseInt(st.nextToken()));
			}
			students.put(student, favoriteFriends);
		}
		
		classroom = new int[N][N];
		
		for(int s : students.keySet()) {
			//System.out.println(s);
			if(!condition1(s)) // 조건1을 수행하는 메소드
				condition2(s); // 조건2를 수행하는 메소드
		}
		
		int total = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int s = classroom[i][j];
				int cnt = 0;
				
				for(int d = 0; d < 4; d++) { // 인접한 칸을 탐색하며
					int r = i + dir[d][0];
					int c = j + dir[d][1];
					if(r >= 0 && r < N && c >= 0 && c < N) {
						if(students.get(s).contains(classroom[r][c])) cnt++;
					}
				}
				
				switch(cnt) {
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
		Collections.sort(possibleSeat);
		
//		System.out.println("con2 " + possibleSeat.toString());
		classroom[possibleSeat.get(0).r][possibleSeat.get(0).c] = student;
		
//		for(int[] c : classroom) {
//			System.out.println(Arrays.toString(c));
//		}
		
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
							} else if(classroom[r][c] == 0){
								emptyCnt++;
							}
						}
					}
				}
				
				if(maxCnt < favoriteFriendsCnt) {
					maxCnt = favoriteFriendsCnt;
					
					possibleSeat.clear();
					possibleSeat.add(new Point(i, j, favoriteFriendsCnt, emptyCnt));
				} else if(maxCnt == favoriteFriendsCnt) {
					possibleSeat.add(new Point(i, j, favoriteFriendsCnt, emptyCnt));					
				}
				
			}
		}
		
		if(possibleSeat.size() == 1) { // 앉을 수 있는 자리가 하나라면 그곳으로 자리를 지정
			classroom[possibleSeat.get(0).r][possibleSeat.get(0).c] = student;
			
//			System.out.println("con1 " + possibleSeat.toString());
//			for(int[] c : classroom) {
//				System.out.println(Arrays.toString(c));
//			}
			
			return true;
		}
		
		return false;
		
	}
	
} // end of class
