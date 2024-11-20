import java.io.*;
import java.util.*;

/**
 * 좀 더 ... 뱀의 몸을 늘리는 방법을 효율적으로 구현해야할거같아...
 */
public class Main_3190_뱀 {
	static class Snake {
		int r, c, d;

		public Snake(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, K, L;
	static boolean[][] board, isSnake;
	static Queue<int[]> dirInfo, snakeBody;
	static Snake snake;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 보드의 크기
		K = Integer.parseInt(br.readLine()); // 사과의 개수
		
		board = new boolean[N][N];
		
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board[r-1][c-1] = true; // 사과의 위치
		}
		
		dirInfo = new LinkedList<>(); // X초가 끝난 뒤 C 방향으로 회전
		L = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수
		for(int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int T = Integer.parseInt(st.nextToken());
			String D = st.nextToken();
			if(D.equals("D")) dirInfo.add(new int[] {T, 1}); // 오른쪽으로 90도 회전
			else dirInfo.add(new int[] {T, -1}); // 왼쪽으로 90도 회전
		}
		
		dirInfo.add(new int[] {Integer.MAX_VALUE, 0});

		snake = new Snake(0, 0, 1);
		isSnake = new boolean[N][N];
		isSnake[0][0] = true;
		snakeBody = new LinkedList<>();
		snakeBody.add(new int[] {0, 0});

		int T = 0;
		int[] command = dirInfo.poll();
		while(true) {
			T++;

			if(move()) {
				if (T == command[0]) { // X초가 지났다면 뱀이 C 방향으로 회전
					if(command[1] > 0) snake.d = (snake.d + command[1])%4;
					else snake.d = (snake.d + 4 + command[1])%4;
					
					command = dirInfo.poll(); // 새로운 뱀의 방향 변환 정보로 갱신
				}
			} else {
				break;
			}
		}

		System.out.println(T);
		
	} // end of main

	// 상 우 하 좌
	static final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	private static boolean move() {
		snake.r += dir[snake.d][0];
		snake.c += dir[snake.d][1];

		if(snake.r >= 0 && snake.r < N && snake.c >= 0 && snake.c < N && !isSnake[snake.r][snake.c]) {
			isSnake[snake.r][snake.c] = true;
			snakeBody.add(new int[] {snake.r, snake.c});
			
			if(board[snake.r][snake.c]) { // 사과가 있다면 사과를 먹고 몸길이 증가
				board[snake.r][snake.c] = false;
			} else {
				int[] tail = snakeBody.poll();
				isSnake[tail[0]][tail[1]] = false;
			}

			return true;
		}

		// 벽을 만나거나 자신의 몸과 부딪힌 경우
		return false;
	}


} // end of class
