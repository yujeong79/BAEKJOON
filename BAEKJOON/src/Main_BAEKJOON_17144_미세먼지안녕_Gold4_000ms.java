import java.io.*;
import java.util.*;

public class Main_BAEKJOON_17144_미세먼지안녕_Gold4_000ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int R, C, T;
	static int[][] map;
	static List<Integer> airPurifier; // 공기청정기의 행 위치 정하기
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		airPurifier = new ArrayList<>();
		map = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) airPurifier.add(i);
			}
		}
		
		diffusion(); // 미세먼지 확산
		operatrion(); // 미세먼지 작동
		
	} // end of main

	private static void operatrion() {
		// TODO Auto-generated method stub
		
	}

	private static void diffusion() {
		// TODO Auto-generated method stub
		
	}
	
} // end of class
