/*
    선수의 수 : 1명 이상 100명 이하
    경기 결과 : 1개 이상 4,500개 이하
*/
import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int INF = 1_000_000;
        int[][] distance = new int[n][n];
        HashSet<Integer>[] hSetArr = new HashSet[n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
            hSetArr[i] = new HashSet<>();
        }
        
        for(int[] res : results) {
            int start = res[0] - 1;
            int end = res[1] - 1;
            
            distance[start][end] = 1;
        }
        
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(distance[i][k] >= INF || distance[k][j] >= INF)
                        continue;
                    
                    // i -> k -> j 경로가 있는 경우
                    distance[i][j] = 1;
                    hSetArr[i].add(j);
                    hSetArr[j].add(i);
                    hSetArr[j].add(k);
                }
            }
        }
        
        int answer = 0;
        for(HashSet hSet : hSetArr) {
            System.out.println(hSet);
            if(hSet.size() == n) answer++;
        }
        
        return answer;
    }
}