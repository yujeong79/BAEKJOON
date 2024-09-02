import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Test {
	static int N; // 참가 선수 수
	static int M; // 수상 선수 수
	static int K; // 등번호 합
	static int[] player; // 999번까지 선수
	static boolean[] sel; // 선택 여부 확인
	static int cnt; // 경우의 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // test case 수

		for (int tc = 1; tc <= T; tc++) {
			cnt = -1; // test case마다 초기화
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 총 참가한 선수
			M = Integer.parseInt(st.nextToken()); // 시상 받는 선수
			K = Integer.parseInt(st.nextToken()); // 등 번호 합.

			player = new int[N]; // 선수 정보 초기화

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < player.length; i++) {
				player[i] = Integer.parseInt(st.nextToken());
			} // 선수들 등 번호 정보 저장

			sel = new boolean[N]; // 선수 탐색 정보
			check(0); // 0부터 시작

			if (cnt != -1) { // 경우의 수가 있으면
				sb.append((cnt + 1) * comb(M)).append("\n");
			} else { // 경우의 수 없으면 -1 그대로
				sb.append(cnt).append("\n");
			}
		} // test case
		System.out.print(sb);
	} // main

	private static void check(int num) {
		// 기저 조건
		if (num == N) { // 끝까지 탐색하면
			sum(num); // 선택된 등번호 합 계산
			return;
		}

		// 재귀 파트
		sel[num] = true; // num이 선택된 경우
		check(num + 1);

		sel[num] = false; // num이 선택 안 된 경우
		check(num + 1);

	} // check

	private static void sum(int length) {
		int sum = 0;
		int check = 0; // 사람 수 확인
		for (int i = 0; i < length; i++) {
			if (sel[i]) { // 선택된 조합이면
				sum += player[i]; // 합 구하기
				check++;
			}
		}

		if (sum == K && check == M) { // 합이 K고, M명이 골라진 경우만
			cnt++; // 경우의 수 증가
		}
	} // sum

	private static int comb(int m) { // M의 등수 경우의 수 판별
		if (m == 1)
			return 1;

		return m * comb(m - 1);
	} // M명 등수 경우의 수

} // class
