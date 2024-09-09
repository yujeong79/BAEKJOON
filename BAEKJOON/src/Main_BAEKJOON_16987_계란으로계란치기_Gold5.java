import java.io.*;
import java.util.*;

class Egg {
	int d, w; // durability, weight

	public Egg(int d, int w) {
		this.d = d;
		this.w = w;
	}

	@Override
	public String toString() {
		return "Egg [d=" + d + ", w=" + w + "]";
	}
}

public class Main_BAEKJOON_16987_계란으로계란치기_Gold5 {
	private static int N;
	//private static Egg[] eggs;
	private static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 계란의 수
		
		Egg[] eggs = new Egg[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int durability = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			eggs[i] = new Egg(durability, weight);
		}
		
		backTracking(0, eggs);
		System.out.println(answer);
	}

	private static void backTracking(int eIdx, Egg[] curr) {
		System.out.println(Arrays.toString(curr));
		
		if(eIdx == N-1) { // 모든 계란을 다 봤으면
			int count = 0;
			for(Egg e : curr) {
				if(e.d <= 0) count++; // 깨진 계란의 수 세기
			}
			answer = Math.max(answer, count); // 업데이트
			return;
		}
		
		if(curr[eIdx].d <= 0) { // 현재 들고 있는 꼐란이 깨지면
			System.out.println(curr[eIdx].d);
			eIdx++; // 현재 계란의 오른쪽 계란을 들고 다시 진행
		}
		
		boolean isPossible = false;
		for(int i = eIdx+1; i < N; i++) { // 깨지지 않은 다른 계란이 없으면 
			if(curr[i].d > 0) {
				isPossible = true;
			}
		}
		if(!isPossible) { eIdx++; }
		
		
		Egg[] temp = new Egg[N]; // 복사
		for(int i = 0; i < N; i++) {
			temp[i] = curr[i];
		}
		
		for(int i = eIdx+1; i < N; i++) {
			if(curr[eIdx].d > 0 && curr[i].d > 0) { // 깰 수 있으면
				temp[eIdx].d = curr[eIdx].d - curr[i].w;
				temp[i].d = curr[i].d - curr[eIdx].w;
			}
			backTracking(eIdx, temp);
		}
	}
	
}
