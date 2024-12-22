import java.io.*;
import java.util.*;

// 11723번 집합 Silver5

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int M, X;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        for(int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            X = 0;
            if(!command.equals("all") && !command.equals("empty"))
                X = Integer.parseInt(st.nextToken());

            switch(command) {
                case "add":
                    if(!find(X)) list.add(X);
                    break;
                case "remove":
                    remove(X);
                    break;
                case "check":
                    check();
                    break;
                case "toggle":
                    if(!remove(X)) list.add(X);
                    break;
                case "all":
                    addAll();
                    break;
                case "empty":
                    list = new ArrayList<>();
                    break;
            }

        }

        System.out.println(sb);
    } // end of main

    private static boolean find(int num) {
        for(int s : list) {
            if((s ^ num) == 0) return true;
        }

        return false;
    }

    private static void check() {
        for(int s : list) {
            if((s ^ X) == 0) { // 집합에 X가 있으면 1 출력
                sb.append(1).append("\n");
                return;
            }
        }

        sb.append(0).append("\n"); // 집합에 X가 없으면 0 출력
    }

    private static boolean remove(int num) {
        int size = list.size();

        for(int i = 0; i < size; i++) {
            if((list.get(i) ^ num) == 0) {
                list.remove(i);
                return true;
            }
        }

        return false;
    }

    private static void addAll() {
        for(int i = 1; i <= 20; i++) {
            if(!find(i)) list.add(i);
        }
    }

} // end of class