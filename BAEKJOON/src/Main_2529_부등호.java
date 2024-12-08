import java.io.*;
import java.util.*;

public class Main_2529_부등호 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k;
    static char[] A;
    static int[] result;
    static boolean[] isSelected;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        k = Integer.parseInt(br.readLine()); // (2 ≤ k ≤ 9)
        A = new char[k];

        String str = br.readLine();
        for(int i = 0; i < k; i++) {
            A[i] = str.charAt(i*2);
        }

        result = new int[k+1];
        isSelected = new boolean[10];
        list = new ArrayList<>();

        perm(0);

        System.out.println(list.get(list.size()-1) + "\n" + list.get(0));

    } // end of main

    private static void perm(int cnt) {
        if(cnt >= k+1) {
            String num = "";
            for(int n : result) num += n + "";
            list.add(num);
            return;
        }

        for(int i = 0; i <= 9; i++) {
            if(cnt == 0 || (!isSelected[i] && isPossible(A[cnt-1], result[cnt-1], i))) {
                isSelected[i] = true;
                result[cnt] = i;
                perm(cnt + 1);

                isSelected[i] = false;
            }
        }
    }

    private static boolean isPossible(char sign, int num1, int num2) {
        switch(sign) {
            case '<':
                if (num1 > num2) return false;
                break;
            case '>':
                if (num1 < num2) return false;
                break;
        }

        return true;
    }

} // end of class
