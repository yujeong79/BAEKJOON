import java.util.*;

class Solution {
    char[][] map;
    int answer;
    
    public int solution(String[] storage, String[] requests) {
        answer = storage.length * storage[0].length();
        
        map = new char[storage.length+2][storage[0].length()+2];
        for(int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], ' ');
        }
        
        for(int i = 1; i <= storage.length; i++) {
            for(int j = 1; j <= storage[i-1].length(); j++) {
                map[i][j] = storage[i-1].charAt(j-1);
            }
        }
        
        for(String request : requests) {
            if(request.length() != 1) { // 크레인으로 모든 컨테이너 제거
                bruteForce(request.charAt(0));
            } else {
                bfs(request.charAt(0));
            }
        }
        
        return answer;
    }
    
    public void bruteForce(char request) {
        for(int i = 1; i < map.length - 1; i++) {
            for(int j = 1; j < map[0].length - 1; j++) {
                if(map[i][j] == request) {
                    map[i][j] = ' ';
                    answer--;
                }
            }
        }
    }
    
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void bfs(char request) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[map.length][map[0].length];
        
        queue.add(new int[]{0, 0});
        isVisited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for(int d = 0; d < 4; d++) {
                int nr = curr[0] + dir[d][0];
                int nc = curr[1] + dir[d][1];
                
                if(nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && !isVisited[nr][nc]) {
                    if(map[nr][nc] == ' ') {
                        queue.add(new int[]{nr, nc});
                        isVisited[nr][nc] = true;
                    }
                    else if(map[nr][nc] == request) {
                        map[nr][nc] = ' ';
                        answer--;
                        isVisited[nr][nc] = true;
                    }
                }
            }
        }
    }
}