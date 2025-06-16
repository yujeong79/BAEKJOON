/*
    같은 시간대에 게임을 이용하는 사람이 m명 늘어날 때마다 서버 1대 추가 필요
    어느 시간대의 이용자가 m명 미만인 경우 유지
    한 번 증설한 서버는 k시간 동안 운영하고 그 이후에 반납
    최초로 m명이 되었을 때 1대, m명 미만인 경우 0대
*/

/*
    players의 길이 = 24, players[0]은 0시부터 1시 사이의 게임 이용자 수
    0 ≤ players의 원소 ≤ 1,000
    1 ≤ m(서버 증설 이용자 수 기준) ≤ 1,000
    1 ≤ k(증설된 서버 이용 시간) ≤ 24
*/
import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int[] servers = new int[24];
        
        int answer = 0;
        for(int i = 0; i < 24; i++) {
            int requiredServers = players[i] / m;
            
            if(servers[i] < requiredServers) {
                requiredServers -= servers[i];
                servers[i] = requiredServers;
                answer += requiredServers;
                
                for(int j = i+1; j < i+k && j < 24; j++) { 
                    servers[j] += requiredServers; 
                }
            }
        }
        
        return answer;
    }
}