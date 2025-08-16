import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 1 <= N <= 80

        DFS("");
    }

    public static void DFS(String sequence) {
        if(sequence.length() == N) {
            System.out.println(sequence);
            System.exit(0);
        }

        for(int i = 1; i <= 3; i++) {
            if(isPossible(sequence+i))
                DFS(sequence+i);
        }
    }

    public static boolean isPossible(String sequence) {
        int size = sequence.length();

        for(int i = 1; i <= size/2; i++) {
            String str1 = sequence.substring(size-i*2, size-i);
            String str2 = sequence.substring(size-i, size);

            if(str1.equals(str2)) {
                return false;
            }
        }

        return true;
    }
}