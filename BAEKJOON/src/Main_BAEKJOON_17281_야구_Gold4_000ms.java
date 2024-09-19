import java.io.*;
import java.util.*;

public class Main_BAEKJOON_17281_야구_Gold4_000ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static int[] players = new int[10];
	static int[] result = new int[9];
	static Queue<Integer> stadium = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 이닝 수
		
		result[0] = 4;
		Perm(1); // 타순 결정, 이미 4번 타자의 순서는 정해졌으므로 1로 시작
		
		String str = br.readLine();
		for(int i = 1, ci = 0; i <= 9; i++, ci+=2) {
			players[i] = str.charAt(ci)-'0';
		}
		
	} // end of main

	private static void Perm(int cnt) {
		
		
	}
	
	
	
} // end of class
