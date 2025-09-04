import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            TreeMap<Integer, Integer> tMap = new TreeMap<>();

            int k = Integer.parseInt(br.readLine()); // k ≤ 1,000,000
            for(int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch (command) {
                    case "I":
                        if(!tMap.containsKey(num)) tMap.put(num, 0);

                        tMap.put(num, tMap.get(num)+1);
                        break;
                    case "D":
                        if(tMap.isEmpty()) break;

                        if(num < 0) {
                            int min = tMap.firstKey();
                            if(tMap.get(min) <= 1) { tMap.remove(min); }
                            else { tMap.put(min, tMap.get(min)-1); }
                        } else {
                            int max = tMap.lastKey();
                            if(tMap.get(max) <= 1) { tMap.remove(max); }
                            else { tMap.put(max, tMap.get(max)-1); }
                        }
                }
            }

            if(tMap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(tMap.lastKey()).append(" ").append(tMap.firstKey()).append("\n");
            }
        } // end of testcase

        System.out.println(sb.toString());
    }
}