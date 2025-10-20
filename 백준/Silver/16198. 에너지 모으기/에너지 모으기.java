import java.io.*;
import java.util.*;

public class Main {
	static int answer;
	static List<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		dfs(N, 0);
		System.out.println(answer);
	}
	
	public static void dfs(int N, int energy) {
		if(N <= 2) {
			answer = Math.max(answer, energy);
			return;
		}
		
		for(int i = 1; i < N-1; i++) {
			int num = list.get(i);
			int result = list.get(i-1) * list.get(i+1);
			
			list.remove(i);
			dfs(N-1, energy+result);
			
			list.add(i, num);
		}
	}
}