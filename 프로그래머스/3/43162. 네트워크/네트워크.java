/**
* 1 <= n <= 200
* computers[i][j] = 1 : i번 컴퓨터와 j번 컴퓨터가 연결 상태
**/
import java.util.*;

class Solution {
    static boolean[] isSelected;
    static boolean[][] isVisited;
    static Queue<Integer> queue;
    static int size;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        size = computers.length;
        isSelected = new boolean[size];
        isVisited = new boolean[size][size];
        queue = new LinkedList<>();
        
        for(int i = 0; i < size; i++) {
            if(!isSelected[i]) { // 아직 네트워크가 없는 경우
                bfs(computers, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void bfs(int[][] computers, int r) {
        for(int c = 0; c < size; c++) {
            if(computers[r][c] == 1) {
                isVisited[r][c] = true;
                queue.add(c);    
            }
        }
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            isSelected[curr] = true;
            
            for(int c = 0; c < size; c++) {
                if(computers[curr][c] == 1 && !isVisited[curr][c]) {
                    isVisited[curr][c] = true;
                    queue.add(c);    
                }    
            } 
        }
    }
}