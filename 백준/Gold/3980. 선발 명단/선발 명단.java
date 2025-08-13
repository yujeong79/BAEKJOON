import java.io.*;
import java.util.*;

/**
    i번 선수가 j번 포지션에서 뛸 때의 능력
    각 선수마다 적합한 포지션의 수는 최대 5개
    모든 포지션의 선수를 채웠을 때, 능력치의 합의 최댓값을 한 줄에 하나씩 출력
**/

public class Main {
    static int[][] players;
    static boolean[] positions;
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            players = new int[11][11];
            positions = new boolean[11];
            answer = 0;
            
            for(int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < 11; j++) {
                    players[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            DFS(0, 0);
            sb.append(answer).append("\n");
        } // end of testcase
        
        System.out.println(sb);
    }
    
    public static void DFS(int player, int sum) {
        if(player >= 11) {
            answer = Math.max(answer, sum);
            return;
        }
        
        for(int i = 0; i < 11; i++) {
            if(players[player][i] > 0 && !positions[i]) {
                positions[i] = true;
                DFS(player+1, sum+players[player][i]);
                
                positions[i] = false;
            }
        }
    }
}