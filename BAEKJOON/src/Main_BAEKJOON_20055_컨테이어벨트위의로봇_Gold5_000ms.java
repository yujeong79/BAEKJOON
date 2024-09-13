import java.io.*;
import java.util.*;

public class Main_BAEKJOON_20055_컨테이어벨트위의로봇_Gold5_000ms {
	static class Space {
		int durability;
		boolean robot;
		
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
	
	static int zeroCount = 0;
	static int level = 0;
	static int lastIndex;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		lastIndex = 2*N - 1;
		
		st = new StringTokenizer(br.readLine(), " ");
		conbeyerBelt = new ArrayList<>();
		for(int i = 0; i < N*2; i++) {
			conbeyerBelt.add(new Space(Integer.parseInt(st.nextToken())));
		}
		
		while(zeroCount < K) { // 내구도가 0인 칸의 개수가 K개 이상이면 종료
			// 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전
			Space lastSpace = conbeyerBelt.get(lastIndex);
			conbeyerBelt.remove(lastSpace);
			conbeyerBelt.add(0, lastSpace);
			
			// 1-1. 내리는 위치에 로봇이 도달하면 내리기
			if(conbeyerBelt.get(N-1).robot) conbeyerBelt.get(N-1).robot = false; 
			
			// 2. 벨트에 올라간 순서대로 로봇 이동
			for(int i = N-2; i >= 0; i--) {
				Space curr = conbeyerBelt.get(i);
				Space next = conbeyerBelt.get(i+1);
				if(curr.robot && next.durability > 0 && !next.robot) {
					curr.robot = false;
					next.robot = true;
					next.durability--;
					if(next.durability == 0) zeroCount++;
					
				}
			}
			
			// 2-1. 내리는 위치에 로봇이 도달하면 내리기
			if(conbeyerBelt.get(N-1).robot) conbeyerBelt.get(N-1).robot = false; 
			
			// 3. 올리는 위치에 로봇 올리기
			conbeyerBelt.get(0).robot = true;
			conbeyerBelt.get(0).durability--;
			if(conbeyerBelt.get(0).durability == 0) zeroCount++;
			
			level++;
			
		}
		
		System.out.println(level);
		
	} // end of main
} // end of class
