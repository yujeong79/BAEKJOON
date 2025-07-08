import java.util.*;

/*
    X는 바다, 숫자는 무인도
    각 칸에 적힌 숫자는 식량
    상, 하, 좌, 우로 연결되는 칸에 적힌 숫자를 모두 합한 값은
    해당 무인도에서 최대 며칠동안 머물 수 있는지를 나타냄
    각 섬에서 최대 며칠씩 머물 수 있는지 오름차순으로 담아 return
*/

class Solution {
    int N;
    int M;
    boolean[][] isVisited;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    List<Integer> answerLst;
    
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        isVisited = new boolean[N][M];
        
        answerLst = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(maps[i].charAt(j) != 'X' && !isVisited[i][j]) {
                    bfs(maps, i, j);
                }
            }
        }
        
        int[] answer = {-1};
        
        if(answerLst.size() > 0) {
            answer = answerLst.stream().mapToInt(i -> i).toArray();
            Arrays.sort(answer);
        }
        
        return answer;
    }
    
    public void bfs(String[] maps, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        isVisited[r][c] = true;
        
        int answer = maps[r].charAt(c) - '0';
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for(int d = 0; d < 4; d++) {
                int nr = curr[0] + dir[d][0];
                int nc = curr[1] + dir[d][1];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || maps[nr].charAt(nc) == 'X' || isVisited[nr][nc])
                    continue;
                
                queue.add(new int[]{nr, nc});
                isVisited[nr][nc] = true;
                answer += maps[nr].charAt(nc) - '0';
            }
        }
        
        answerLst.add(answer);
    }
}