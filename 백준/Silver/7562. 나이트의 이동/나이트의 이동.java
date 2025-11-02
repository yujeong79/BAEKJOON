import java.io.*;
import java.util.*;

public class Main {
	static int l;
	static int[][] dir = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0) {
			 l = Integer.parseInt(br.readLine()); // 한 변의 길이, 4 ≤ l ≤ 300
			 StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			 int startR = Integer.parseInt(st.nextToken());
			 int startC = Integer.parseInt(st.nextToken());
			 
			 st = new StringTokenizer(br.readLine(), " ");
			 int endR = Integer.parseInt(st.nextToken());
			 int endC = Integer.parseInt(st.nextToken());
			 
			 sb.append(dfs(startR, startC, endR, endC)).append("\n");
			 
		} // end of test case
		
		System.out.println(sb);
	}
	
	public static int dfs(int startR, int startC, int endR, int endC) {
		Queue<int[]> queue = new LinkedList<>();
		int[][] isVisited = new int[l][l];
		for(int[] line : isVisited) {
			Arrays.fill(line, Integer.MAX_VALUE);
		}
		
		queue.add(new int[] {startR, startC, 0});
		isVisited[startR][startC] = 0;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			if(curr[0] == endR && curr[1] == endC)
				return curr[2];
			
			for(int d = 0; d < 8; d++) {
				int nr = curr[0] + dir[d][0];
				int nc = curr[1] + dir[d][1];
				
				if(nr < 0 || nr >= l || nc < 0 || nc >= l || isVisited[nr][nc] <= curr[2]+1)
					continue;
				
				queue.add(new int[] {nr, nc, curr[2]+1});
				isVisited[nr][nc] = curr[2]+1;
			}
		}
		
		return -1;
	}
}