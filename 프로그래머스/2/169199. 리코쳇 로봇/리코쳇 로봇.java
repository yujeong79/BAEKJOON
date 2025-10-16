import java.util.*;

class Solution {
    int N, M;
    char[][] map;
    int[][] isVisited;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int solution(String[] board) {
        N = board.length; // 3 ≤ board의 길이 ≤ 100
        M = board[0].length(); // 3 ≤ board의 원소의 길이 ≤ 100
        
        int rr = 0; int rc = 0;
        map = new char[N][M];
        isVisited = new int[N][M];
        for(int i = 0; i < N; i++) {
            Arrays.fill(isVisited[i], -1);
            
            for(int j = 0; j < M; j++) {
                map[i][j] = board[i].charAt(j);
                
                if(map[i][j] == 'R') {
                    rr = i;
                    rc = j;
                }
            }
        }
        
        int answer = bfs(rr, rc);
        for(int[] row : isVisited){
            System.out.println(Arrays.toString(row));
        }
        
        return answer;
    }
    
    public int bfs(int rr, int rc) {
        Queue<int[]> queue = new LinkedList<>();
        isVisited[rr][rc] = 0;
        queue.add(new int[]{rr, rc});
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            if(map[curr[0]][curr[1]] == 'G') {
                return isVisited[curr[0]][curr[1]];
            }
            
            for(int d = 0; d < 4; d++) {
                int cr = curr[0]; int cc = curr[1];
                
                int nr = curr[0] + dir[d][0];
                int nc = curr[1] + dir[d][1];
                
                while(isRange(nr, nc)) {
                    cr = nr; cc = nc;
                    
                    nr += dir[d][0];
                    nc += dir[d][1];
                }
                
                if(isVisited[cr][cc] < 0) {
                    queue.add(new int[]{cr, cc});
                    isVisited[cr][cc] = isVisited[curr[0]][curr[1]] + 1;
                }
                
            }
        }
        
        return -1;
    }
    
    public boolean isRange(int r, int c) {
        if(r < 0 || c < 0 || r >= N || c >= M || map[r][c] == 'D') {
            return false;
        }
        
        return true;
    }
    
}