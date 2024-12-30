import java.io.*;
import java.util.*;

// 2866번 문자열 잘라내기 Gold5

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, C, answer;
    static String[] words;

    static HashMap<String, Integer> hmap;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken()); // (2 ≤ R, C ≤ 1000)
        C = Integer.parseInt(st.nextToken());

        words = new String[R];
        for(int i = 0; i < R; i++) {
            words[i] = br.readLine();
        }

        System.out.println(binarySearch());

    } // end of main

    private static int binarySearch() {
        int start = 0;
        int end = R - 1;

        int ans = R-1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(round(mid)) {
                start = mid + 1;
                ans = mid;
            }

            else end = mid - 1;
        }

        return ans;
    }

    private static boolean round(int start) {
        hmap = new HashMap<>();
        for(int c = 0; c < C; c++) {
            String word = "";
            for(int r = start; r < R; r++) {
                word += words[r].charAt(c) + "";
            }

            if(hmap.containsKey(word)) return false;

            hmap.put(word, 1);
        }

        return true;
    }

} // end of class