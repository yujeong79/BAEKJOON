import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int answer;
    static boolean[][] words;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 1 <= N <= 50
        K = Integer.parseInt(st.nextToken()); // 0 <= K <= 26

        words = new boolean[N][26];
        for(int i = 0; i < N; i++) {
            String word = br.readLine(); // 글자의 길이는 8 이상 15 이하
            for(int j = 4; j < word.length()-4; j++) { // anta ... tica 제외
                words[i][word.charAt(j)-'a'] = true;
            }
        }

        if(K < 5) {
            System.out.println(0);
            return;
        }

        char[] duplicated = {'a', 'n', 't', 'i', 'c'};
        isSelected = new boolean[26];
        for(char d : duplicated) {
            isSelected[d-'a'] = true;
        }

        answer = 0;
        comb(5, 0);
        System.out.println(answer);
    }

    public static void comb(int cnt, int idx) {
        if(cnt >= K) {
            countWords();
            return;
        }

        for(int i = idx; i < 26; i++) {
            if(!isSelected[i]) {
                isSelected[i] = true;
                comb(cnt+1, i+1);

                isSelected[i] = false;
            }
        }
    }

    public static void countWords() {
        int cnt = 0;

        for(boolean[] word : words) {
            boolean isPossible = true;

            for(int i = 0; i < 26 && isPossible; i++) {
                if(word[i] && !isSelected[i]) {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) cnt++;
        }

        answer = Math.max(answer, cnt);
    }
}