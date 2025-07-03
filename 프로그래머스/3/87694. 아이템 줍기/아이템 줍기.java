/*
    1 <= 좌표 값 <= 50
    1 <= 직사각형의 개수 <= 4
    직사각형의 모든 좌표가 1 이상 50 이하라면 
*/

import java.util.*;

class Solution {
    int[][] map;
    boolean[][] isVisited;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    class Coord {
        int r;
        int c;
        int distance;
        
        public Coord (int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        isVisited = new boolean[101][101];
        for(int[] r : rectangle) {
            for(int i = r[0]*2; i <= r[2]*2; i++) {
                for(int j = r[1]*2; j <= r[3]*2; j++) {
                    if(i == r[0]*2 || i == r[2]*2 || j == r[1]*2 || j == r[3]*2) {
                        if(map[i][j] != 2)
                            map[i][j] = 1;
                    }
                    else map[i][j] = 2;
                }
            }
        }
        
        int answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2); 
        return answer;
    }
    
    public int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<Coord> queue = new LinkedList<>();
        queue.add(new Coord(characterX, characterY, 0));
        isVisited[characterX][characterY] = true;
        
        int answer = 0;
        while(!queue.isEmpty()) {
            Coord curr = queue.poll();
            if(curr.r == itemX && curr.c == itemY) {
                answer = curr.distance/2;
                break;
            }
            
            for(int d = 0; d < 4; d++) {
                int nr = curr.r + dir[d][0];
                int nc = curr.c + dir[d][1];
                
                if(nr < 0 || nr > 100 || nc < 0 || nc > 100 || isVisited[nr][nc] || map[nr][nc] != 1) 
                    continue;
                
                isVisited[nr][nc] = true;
                queue.add(new Coord(nr, nc, curr.distance + 1));
            }
        }
        
        return answer;
    }
}