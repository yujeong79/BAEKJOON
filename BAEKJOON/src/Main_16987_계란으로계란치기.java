import java.io.*;
import java.util.*;

public class Main_16987_계란으로계란치기 {
	static class Egg {
		int d, w;

		public Egg(int d, int w) {
			this.d = d;
			this.w = w;
		}
	}
	
	static void init() {
		eggs = new Egg[N];
		isBroken = new boolean[N];
		maxCnt = 0;
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, maxCnt, totalW; // 계란의 수
	static Egg[] eggs;
	static boolean[] isBroken; // 해당 계란이 깨졌는지 유무를 저장
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 계란의 수, (1 ≤ N ≤ 8)
		
		init();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			eggs[i] = new Egg(d, w);
		}
		
		backTracking(0);
		
		System.out.println(maxCnt);
	} // end of main

	private static void backTracking(int idx) {
 		if(idx >= N) {
			return;
		}
		
		if(isBroken[idx]) {
			backTracking(idx+1); // 다음 계란이 깨진 경우에 다른 계란을 왼손에 쥐기
			return;
		}
		
		Egg curr = eggs[idx]; // 현재 왼손에 쥐고 있는 계란
		
		for(int i = 0; i < N; i++) {
			if(idx != i && !isBroken[i]) { // 자기 자신이 아니고 i번째 계란이 아직 깨지지 않은 경우에
				
				int leftD = curr.d; // 왼손 계란의 내구도
				int rightD = eggs[i].d; // 오른손 계란의 내구도
				
				if(rightD - curr.w <= 0) { // 왼쪽 계란으로 쳤을 때 깨지면
					isBroken[i] = true;
					eggs[i].d = 0;
				} else { // 깨지지 않았으면? 내구도를 바꿔야 하자나
					eggs[i].d -= curr.w; // 내구도 curr.w만큼 감소
				}
				
				curr.d -= eggs[i].w;
				
				if(curr.d <= 0) { // 왼손 계란의 내구도가 0 이하가 되면
					curr.d = 0;
					isBroken[idx] = true;
				} 
				
				int brokenCnt = 0;
				for(int e= 0; e < N; e++) {
					if(isBroken[e]) brokenCnt++;
				}
				
				maxCnt = Math.max(maxCnt, brokenCnt);
				
				backTracking(idx+1);
				
				// 원상복구
				isBroken[idx] = false;
				isBroken[i] = false;
				
				eggs[i].d = rightD;
				curr.d = leftD;
			}
		}
	}
	
} // end of class
