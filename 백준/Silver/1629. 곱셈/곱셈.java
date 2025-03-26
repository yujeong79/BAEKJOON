import java.io.*;
import java.util.*;

public class Main {
    static long A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Long.parseLong(st.nextToken()); //  2,147,483,647 이하
        B = Long.parseLong(st.nextToken()); //  2,147,483,647 이하
        C = Long.parseLong(st.nextToken()); //  2,147,483,647 이하

        System.out.println(pow(B));
    }

    static long pow(long cnt) {
        if(cnt <= 1) return A%C;

        long result = pow(cnt/2);

        if(cnt % 2 == 0) return (result * result % C);
        return (result * result % C) * A % C;
    }
}