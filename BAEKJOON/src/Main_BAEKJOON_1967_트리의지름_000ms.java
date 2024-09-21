import java.io.*;
import java.util.*;

public class Main_BAEKJOON_1967_트리의지름_000ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] adjArr;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		adjArr = new int[N+1][N+1];
		
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjArr[node1][node2] = weight;
			adjArr[node2][node1] = weight;
		}
		
	} // end of main
} // end of class
