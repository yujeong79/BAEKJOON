import java.io.*;
import java.util.*;

public class Main_1484_다이어트 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int G = Integer.parseInt(br.readLine()); // 100,000 이하

        int past = 1;
        int curr = past+1;

        String answer = "";

        while(past <= curr && curr <= (G+1)/2) {
            int g = curr*curr - past*past;
            if(g == G) {
                answer += curr + "\n";
                past++;
                curr++;
            } else {
                if(g < G) {
                    curr++;
                } else {
                    past++;
                }
            }
        }

        if(answer.length() == 0) System.out.println(-1);
        else System.out.println(answer);
    } // end of main
} // end of class
