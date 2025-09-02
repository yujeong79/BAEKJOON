import java.util.*;

/*
    1 ≤ n, m ≤ 500
    1. BFS를 통해 덩어리의 크기를 구한다.
    
*/

class Solution {
    int N, M;
    int[][] tLand;
    boolean[][] isVisited;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[] col;
    
    public int solution(int[][] land) {
        tLand = land;
        N = land.length;
        M = land[0].length;
        
        isVisited = new boolean[N][M];
        col = new int[M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(land[i][j] != 0 && !isVisited[i][j]) 
                    bfs(i, j);
            }
        }
        
        Arrays.sort(col);
        return col[M-1];
    }
    
    public void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        isVisited[r][c] = true;
        queue.add(new int[]{r, c});
        
        int size = 1;
        int s = c;
        int e = c;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            s = Math.min(s, curr[1]);
            e = Math.max(e, curr[1]);
            
            for(int d = 0; d < 4; d++) {
                int nr = curr[0] + dir[d][0];
                int nc = curr[1] + dir[d][1];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc] || tLand[nr][nc] == 0) 
                    continue;
                
                isVisited[nr][nc] = true;
                queue.add(new int[]{nr, nc});
                size++;
            }
        }
        
        for(int i = s; i <= e; i++) {
            col[i] += size;
        }
        
    }
}