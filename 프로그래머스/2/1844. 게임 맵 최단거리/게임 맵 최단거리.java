import java.io.*;
import java.util.*;

class Solution {
    static class Coord {
        int r, c, cnt;
        
        public Coord(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우
    
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        
        return answer;
    }
    
    static int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<Coord> pq = new LinkedList();
        pq.add(new Coord(0, 0, 1));
        
        boolean[][] isVisited = new boolean[n][m];
        isVisited[0][0] = true;
        
        while(!pq.isEmpty()) {
            Coord curr = pq.poll();
            
            if(curr.r == n-1 && curr.c == m-1)  return curr.cnt; // (n, m) 지점에 도착한 경우 칸의 갯수를 반환
            
            for(int d = 0; d < 4; d++) {
                int nr = curr.r + dir[d][0];
                int nc = curr.c + dir[d][1];
                
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !isVisited[nr][nc] && maps[nr][nc] == 1) {           
                    pq.add(new Coord(nr, nc, curr.cnt + 1));
                    isVisited[nr][nc] = true;
                }
            }
        }
        
        return -1;
        
    }
}