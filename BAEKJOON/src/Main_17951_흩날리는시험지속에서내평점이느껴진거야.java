import java.io.*;
import java.util.*;

/**
 * 시험지를 현재 순서 그대로 K개의 그룹으로 나눈 뒤
 * 각각의 그룹에서 맞은 문제 개수의 합을 구하여 그 중 최솟값이 시험 점수이다.
 * 이번 시험에서 받을 수 있는 최대 점수를 계산하는 프로그램을 작성하자.
 */

public class Main_17951_흩날리는시험지속에서내평점이느껴진거야 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, K;
	static int[] papers;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 시험지의 개수 
		K = Integer.parseInt(st.nextToken()); // 시험지를 난루 그룹의 수
		
		papers = new int[N];
		
	} // end of main
} // end of class
