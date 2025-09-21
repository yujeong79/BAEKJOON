import java.util.*;

class Solution {
    class Coord {
        int r;
        int c;
        int hasLever;
        int t;
        
        Coord(int r, int c, int hasLever, int t) {
            this.r = r;
            this.c = c;
            this.hasLever = hasLever;
            this.t = t;
        }
    }
    
    int N, M;
    char[][] tMaps;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int solution(String[] maps) {
        N = maps.length; // 5 ≤ N ≤ 100 
        M = maps[0].length(); // 5 ≤ M ≤ 100
        tMaps = new char[N][M];
        
        int r = 0; int c = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                tMaps[i][j] = maps[i].charAt(j);
                
                if(tMaps[i][j] == 'S') {
                    r = i; c = j;
                }
            }
        }
        
        return BFS(r, c);
    }
    
    public int BFS(int r, int c) {
        Queue<Coord> queue = new LinkedList<>();
        boolean[][][] isVisited = new boolean[2][N][M];
        isVisited[0][r][c] = true;
        queue.add(new Coord(r, c, 0, 0));
        
        while(!queue.isEmpty()) {
            Coord curr = queue.poll();
            if(tMaps[curr.r][curr.c] == 'L') 
                curr.hasLever = 1;
            
            if(curr.hasLever == 1 && tMaps[curr.r][curr.c] == 'E')
                return curr.t;
            
            for(int d = 0; d < 4; d++) {
                int nr = curr.r + dir[d][0];
                int nc = curr.c + dir[d][1];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || tMaps[nr][nc] == 'X' || isVisited[curr.hasLever][nr][nc])
                    continue;
                
                queue.add(new Coord(nr, nc, curr.hasLever, curr.t+1));
                isVisited[curr.hasLever][nr][nc] = true;                                                                
            }
        }

        return -1;
    }
}