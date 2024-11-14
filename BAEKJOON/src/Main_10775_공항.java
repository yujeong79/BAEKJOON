import java.io.*;
import java.util.Arrays;

/**
 * g번째 게이트에 도킹했다면 g번째 게이트에는 g-1를 저장한다. 이미 g번째 게이트를 사용했으므로
 * 그리고 이제 g번째 게이트로 또 들어온다면 g-1에 저장하고 g-1은 g-2, g도 g-2를 저장하겠지
 */

public class Main_10775_공항 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int G, P, answer;
	static boolean success;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		G = Integer.parseInt(br.readLine()); // 게이트의 수
		P = Integer.parseInt(br.readLine()); // 비행기의 수
		
		parents = new int[G+1];
		
		for(int i = 1; i <= G; i++) {
			parents[i] = i; // 해당 인덱스로 비행기가 들어오는 경우 해당 값에 도킹
		}
		
		for(int i = 1; i <= P; i++) {
			int g = Integer.parseInt(br.readLine()); // 게이트 번호를 받았어 그러면
			
			int p = findParent(g);
			
			if(p != 0) {
				answer++;
				union(p, p-1);
			} else {
				break;
			}
		}
		
		System.out.println(answer);
	} // end of main

	private static void union(int p, int next) {
		int pn = findParent(next);
		
		parents[p] = pn;
	}

	private static int findParent(int g) {
		if(g != parents[g]) 
			return parents[g] = findParent(parents[g]);
		
		return g;
	}

} // end of class
