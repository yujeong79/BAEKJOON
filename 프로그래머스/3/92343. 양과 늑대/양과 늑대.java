import java.util.*;

class Solution {
    int[] tInfo;
    int[][] tEdges;
    int answer;
    
    public int solution(int[] info, int[][] edges) {
        tInfo = info;
        tEdges = edges;
        boolean[] isVisited = new boolean[info.length];
        
        dfs(0, isVisited, 0, 0);
        return answer;
    }
    
    public void dfs(int idx, boolean[] isVisited, int sCnt, int wCnt) {
        isVisited[idx] = true;
        if(tInfo[idx] == 0) {
            sCnt++;
            answer = Math.max(answer, sCnt);
        } else {
            wCnt++;
        }
        
        if(wCnt >= sCnt) return;
        
        for(int[] e : tEdges) {
            // 부모는 방문했어도 자식은 아직 방문하지 않은 모든 자식들을 DFS
            if(isVisited[e[0]] && !isVisited[e[1]]) {
                boolean[] nextVisited = isVisited.clone();
                dfs(e[1], nextVisited, sCnt, wCnt); // 자식 방문
            }
        }
    }
}