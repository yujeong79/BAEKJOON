import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 접시의 수, 2 ≤ N ≤ 30,000
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수, 2 ≤ d ≤ 3,000
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수, 2 ≤ k ≤ 3,000
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호, 1 ≤ c ≤ d
		
		int[] sushi = new int[N];
		for(int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		Map<Integer, Integer> eatenTypes = new HashMap<>();
		for(int i = 0; i < k; i++) {
			if(!eatenTypes.containsKey(sushi[i])) {
				eatenTypes.put(sushi[i], 0);
			}
			
			eatenTypes.put(sushi[i], eatenTypes.get(sushi[i])+1);
		}
		
		int answer = eatenTypes.containsKey(c) ? eatenTypes.size() : eatenTypes.size() + 1;
		for(int i = 1; i <= N; i++) {
			int prev = (i - 1 + N) % N;
			int next = (i + k - 1 + N) % N;
			
			if(eatenTypes.get(sushi[prev]) == 1) {
				eatenTypes.remove(sushi[prev]);
			} else {
				eatenTypes.put(sushi[prev], eatenTypes.get(sushi[prev])-1);
			}
			
			if(!eatenTypes.containsKey(sushi[next])) {
				eatenTypes.put(sushi[next], 0);
			}
			
			eatenTypes.put(sushi[next], eatenTypes.get(sushi[next])+1);
			answer = Math.max(answer, eatenTypes.containsKey(c) ? eatenTypes.size() : eatenTypes.size() + 1);
		}
		
		System.out.println(answer);
	}
}