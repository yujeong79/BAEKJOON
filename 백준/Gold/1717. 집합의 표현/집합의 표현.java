import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 각 집합의 부모를 저장하는 배열 초기화
        parent = new int[n+1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int pa = findParent(a);
            int pb = findParent(b);

            switch(command) {
                case "0":
                    if(pa != pb) union(pa, pb);
                    break;
                case "1":
                    if(pa != pb) System.out.println("NO");
                    else System.out.println("YES");
                    break;
            }
        }
    }

    public static void union(int pa, int pb) {
        if(pa < pb) parent[pb] = pa;
        else parent[pa] = pb;
    }

    public static int findParent(int point) {
        if(parent[point] != point)
            return parent[point] = findParent(parent[point]);

        return point;
    }
}