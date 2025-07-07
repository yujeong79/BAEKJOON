/**
* 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어 있고, 
* 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때
* 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있음
* 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 있을 때,
* 네트워크의 개수를 return 하도록 solution 함수를 작성
*
* 1 <= n <= 200
* computers[i][j] = 1 : i번 컴퓨터와 j번 컴퓨터가 연결 상태
**/
import java.util.*;

class Solution {
    boolean[] isSelected;
    
    public int solution(int n, int[][] computers) {
        isSelected = new boolean[n];
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(!isSelected[i]) {
                bfs(computers, n, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int[][] computers, int n, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isSelected[start] = true;
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            
            for(int i = 0; i < n; i++) {
                if(computers[curr][i] == 1 && !isSelected[i]) {
                    queue.add(i);
                    isSelected[i] = true;
                }
            }
        }
    }
}