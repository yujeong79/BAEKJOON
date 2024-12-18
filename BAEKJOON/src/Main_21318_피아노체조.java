import java.io.*;
import java.util.*;

public class Main_21318_피아노체조 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, Q;
    static int[] difficulty;
    static int[] memories;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 악보의 개수, (1 ≤ N ≤ 100,000)

        memories = new int[N+1];
        difficulty = new int[N+1]; // 난이도, (1 <= difficulty[i] <= 1,000,000,000)
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            difficulty[i] = Integer.parseInt(st.nextToken());

            if(difficulty[i-1] > difficulty[i]) {
                memories[i] = memories[i-1] + 1;
            } else {
                memories[i] = memories[i-1];
            }
        }

        Q = Integer.parseInt(br.readLine()); // 질문의 개수, (1 ≤ Q ≤ 100,000)
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(memories[y] - memories[x]).append("\n");
        }

        System.out.println(sb);

    } // end of main
} // end of class
