import java.io.*;
import java.util.*;

public class Main_BAEKJOON_20055_컨베이어벨트위의로봇_Gold5_304ms {
	static class Space { // 컨베이어벨트의 한 칸을 저장하기 위한 클래스
		int durability; // 내구도
		boolean robot; // 로봇의 유무
		
		public Space(int durability) {
			this.durability = durability;
		}

		@Override
		public String toString() {
			return "[Space 내구도 : " + durability + ", 로봇 : " + robot + "]";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, K;
	static List<Space> conbeyerBelt;
	
	static int zeroCount = 0; // 내구도가 0인 칸을 세기 위한 변수
	static int level = 0;
	static int lastIndex;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		lastIndex = 2*N - 1; // 자주쓰이니까 마지막 인덱스를 저장해두자
		
		st = new StringTokenizer(br.readLine(), " ");
		conbeyerBelt = new ArrayList<>();
		for(int i = 0; i < N*2; i++) {
			conbeyerBelt.add(new Space(Integer.parseInt(st.nextToken())));
		}
		
		while(zeroCount < K) { // 내구도가 0인 칸의 개수가 K개 이상이면 종료
			// 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전
			Space lastSpace = conbeyerBelt.get(lastIndex); // 마지막 인덱스를 가져와서
			conbeyerBelt.remove(lastSpace); 
			conbeyerBelt.add(0, lastSpace); // 맨 앞에 넣으면 회전 구현 가능
			
			// 1-1. 내리는 위치에 로봇이 도달하면 내리기
			if(conbeyerBelt.get(N-1).robot) conbeyerBelt.get(N-1).robot = false; 
			
			// 2. 벨트에 올라간 순서대로 로봇 이동
			for(int i = N-2; i >= 0; i--) {
				Space curr = conbeyerBelt.get(i); // 현재 칸
				Space next = conbeyerBelt.get(i+1); // 다음 칸
				if(curr.robot && next.durability > 0 && !next.robot) { // 현재 칸에 로봇이 있고 && 다음 칸의 내구도가 0보다 크고 && 다음 칸에 로봇이 없다면
					curr.robot = false;
					next.robot = true;
					next.durability--;
					if(next.durability == 0) zeroCount++; // 내구도가 0이 되면 zeroCount++;
					
				}
			}
			
			// 2-1. 내리는 위치에 로봇이 도달하면 내리기
			if(conbeyerBelt.get(N-1).robot) conbeyerBelt.get(N-1).robot = false; 
			
			// 3. 올리는 위치에 로봇 올리기
			if(conbeyerBelt.get(0).durability > 0) { // 올리는 위치의 내구도가 0 보다 크다면 올리기
				conbeyerBelt.get(0).robot = true;
				conbeyerBelt.get(0).durability--;
				if(conbeyerBelt.get(0).durability == 0) zeroCount++;
			}
			
			level++;
		}
		
		System.out.println(level);
	} // end of main
} // end of class
