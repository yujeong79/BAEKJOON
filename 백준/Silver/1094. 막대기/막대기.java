import java.io.*;
import java.util.*;

// 1094번 막대기 Silver5

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int X, answer;

    public static void main(String[] args) throws IOException {
        X = Integer.parseInt(br.readLine());

        int mask = 1;

        while(X > 0) {
            if((X & mask) == mask) answer++;
            X = X >> 1;
        }

        System.out.println(answer);

    } // end of main
} // end of class