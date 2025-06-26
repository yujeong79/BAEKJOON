import java.util.*;

class Solution {
    int X; // 로봇의 수
    Queue<int[]>[] robots; // 로봇의 경로를 저장하기 위한 큐
    
    public int solution(int[][] points, int[][] routes) {
        X = routes.length;
        robots = new LinkedList[X];
        
        for(int i = 0; i < X; i++) {
            robots[i] = new LinkedList<>();
            findRoute(points, i, routes[i]);
        }
        
        int answer = countCollision();
        return answer;
    }
    
    public int countCollision() {
        int answer = 0;
        int emptyCnt = 0;
        
        while(emptyCnt < X) {
            int[][] map = new int[101][101];
            
            emptyCnt = 0;
            for(int i = 0; i < X; i++) {
                if(robots[i].isEmpty()) {
                    emptyCnt++;
                    continue;
                }
                
                int[] curr = robots[i].poll();
                map[curr[0]][curr[1]]++;
            }
            
            for(int i = 1; i < 101; i++) {
                for(int j = 1; j < 101; j++) {
                    if(map[i][j] > 1) answer++;
                }
            }
        }
        
        return answer;
    }
    
    public void findRoute(int[][] points, int idx, int[] route) {
        int M = route.length - 1;
        
        int startR = points[route[0] - 1][0];
        int startC = points[route[0] - 1][1];
        robots[idx].add(new int[]{startR, startC});
        
        for(int i = 0; i < M; i++) {
            int[] start = points[route[i] - 1];
            int[] end = points[route[i+1] - 1];
            
            int r = start[0];
            int c = start[1];
            
            while(r != end[0]) {
                if(r < end[0]) r++;
                else r--;
                
                robots[idx].add(new int[]{r, c});
            }
            
            while(c != end[1]) {
                if(c < end[1]) c++;
                else c--;
                
                robots[idx].add(new int[]{r, c});
            }
        }
    }
}