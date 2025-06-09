import java.io.*;
import java.util.*;

/**
* 한국에는 도시가 N개 있고 임의의 두 도시 사이에 길이 있을 수도 없을 수도 있다.
* 여행 일정이 주어졌을 때, 이 여행 경로가 가능한 것인지 알아보자.
**/

public class Main {
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // N : 도시의 수, 200이하
        int M = Integer.parseInt(br.readLine()); // M : 여행 계획에 속한 도시의 수, 1000이하
        
        // 부모를 저장하는 배열 초기화
        parent = new int[N+1];
        for(int i = 1; i <= N; i++) parent[i] = i;
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                String isConnected = st.nextToken(); // 1:연결, 0:연결X
                if(isConnected.equals("1")) {
                    int pa = findParent(i+1);
                    int pb = findParent(j+1);
                    
                    if(pa != pb) union(pa, pb);
                }
            }
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String answer = "YES";
        int start = findParent(Integer.parseInt(st.nextToken())); // 첫 번째 여행지의 부모
        for(int i = 1; i < M; i++) {
            int curr = findParent(Integer.parseInt(st.nextToken()));
            if(start != curr) {
                answer = "NO";
                break;
            }
        }
        
        System.out.println(answer);
    }
    
    public static int findParent(int child) {
        if(parent[child] != child)
            return parent[child] = findParent(parent[child]);
        
        return child;
    }
    
    public static void union(int pa, int pb) {
        if(pa < pb) parent[pb] = pa;
        else parent[pa] = pb;
    }
}