import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String commands = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), ",|[|]");
            int[] arr = new int[n];
            int idx = 0;
            while(st.hasMoreTokens()) {
                String token = st.nextToken();
                arr[idx++] = Integer.parseInt(token);
            }

            int rCnt = 0;
            int dCnt = 0;
            int lIdx = 0;
            int rIdx = n-1;
            for(int i = 0; i < commands.length(); i++) {
                switch(commands.charAt(i)) {
                    case 'R':
                        rCnt++;
                        break;
                    case 'D':
                        dCnt++;
                        if(rCnt % 2 != 0) rIdx--;
                        else lIdx++;
                        break;
                }
            }

            if(dCnt > n) sb.append("error").append("\n");
            else {
                if(lIdx > rIdx) sb.append("[]").append("\n");
                else {
                    arr = Arrays.copyOfRange(arr, lIdx, rIdx+1);
                    if(rCnt % 2 != 0) {
                        for(int i = 0; i < arr.length/2; i++) {
                            int tmp = arr[i];
                            arr[i] = arr[arr.length-i-1];
                            arr[arr.length-i-1] = tmp;
                        }
                    }

                    sb.append("[");
                    for(int i = 0; i < arr.length-1; i++) {
                        sb.append(arr[i]).append(",");
                    }
                    sb.append(arr[arr.length-1]).append("]").append("\n");
                }
            }
        } // end of test case

        System.out.println(sb);
    }
}