import java.util.*;

/*
    다이아몬드 곡괭이, 철곡괭이, 돌 곡괭이를 각각 0개에서 5개까지 보유
    곡괭이로 광물을 캘 때는 피로도가 소모
    
    사용할 수 있는 곡괭이 중 아무거나 하나를 선택해 광물을 캔다.
    한 번 사용하기 시작한 곡괭이는 사용할 수 없을 때까지 사용한다.
    광물은 주어진 순서대로만 캘 수 있다.
    광산에 있는 모든 광물을 캐거나, 더 사용할 곡괭이가 없을 때까지 광물을 캔다.
    
    갖고 있는 곡괭이의 개수[다이아몬드, 철, 돌] : picks
    광물들의 순서를 나타내는 문자열 배열 : minerals
    마인이 작업을 끝내기까지 필요한 최소한의 피로도를 return
*/

class Solution {
    static int N, M, answer;
    static int[] tPicks;
    static int[] tMinerals;
    static int[][] board = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    
    public int solution(int[] picks, String[] minerals) {
        N = minerals.length;
        M = picks[0] + picks[1] + picks[2];
        tPicks = picks;
        tMinerals = new int[N];
        for(int i = 0; i < N; i++) {
            switch (minerals[i]) {
                case "diamond":
                    tMinerals[i] = 0;
                    break;
                case "iron":
                    tMinerals[i] = 1;
                    break;
                case "stone":
                    tMinerals[i] = 2;
                    break;
            }
        }
        
        answer = Integer.MAX_VALUE;
        dfs(M, 0, 0);
        return answer;
    }
    
    public void dfs(int cnt, int idx, int sum) {
        if(idx >= N || cnt == 0) {
            answer = Math.min(answer, sum);
            return;
        }
        
        for(int pick = 0; pick < 3; pick++) {
            if(tPicks[pick] > 0) { // 현재 곡괭이를 사용할 수 있다면
                int result = 0;
                int m = idx;
                for(; m < idx+5 && m < N; m++) {
                    int mineral = tMinerals[m];
                    result += board[pick][mineral];
                }
                
                tPicks[pick]--;
                dfs(cnt-1, m, sum+result);
                
                tPicks[pick]++; // 원상복구
            }
        }
    }
}