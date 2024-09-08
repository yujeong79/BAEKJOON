import java.io.*;
import java.util.*;

class Egg {
	int d, w; // durability, weight

	public Egg(int d, int w) {
		this.d = d;
		this.w = w;
	}
}

public class Main_BAEKJOON_16987_계란으로계란치기_Gold5 {
	private static int N;
	private static Egg[] eggs;
	private static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 계란의 수
		
		eggs = new Egg[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int durability = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			eggs[i] = new Egg(durability, weight);
		}
		
		backTracking(0);
	}

	private static void backTracking(int eIdx) {
		if(eIdx >= N) { // 모든 계란을 다 봤으면
			int count = 0;
			for(Egg e : eggs) {
				if(e.d <= 0) count++; // 깨진 계란의 수 세기
			}
			answer = Math.max(answer, count); // 업데이트
			return;
		}
		
		for(int i = eIdx+1; i < N; i++) {
			if(eggs[eIdx].d > 0 && eggs[i].d > 0) { // 깰 수 있으면
				eggs[eIdx].d -= eggs[i].w;
				eggs[i].d -= eggs[eIdx].w;
			}
			backTracking(eIdx+1);
		}
		
	}
	
}
