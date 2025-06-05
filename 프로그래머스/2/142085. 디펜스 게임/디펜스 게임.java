/*
    처음 가지고 있는 병사의 수 : 1 이상 10억 이하
    무적권의 횟수 : 1 이상 50만 이하
    라운드의 수 : 1 이상 100만 이하
    한 라운드의 적의 수 : 1 이상 100만 이하
*/
import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = binarySearch(n, k, enemy);
        return answer;
    }
    
    public int binarySearch(int n, int k, int[] enemy) {
        int start = 0;
        int end = enemy.length - 1;
        
        int answer = 1;
        while(start <= end) {
            int mid = (start+end)/2;
            
            if(isPossible(n, k, enemy, mid)) { // 현재 라운드까지 가능하다면
                answer = mid;
                start = mid + 1;
            } else { // 현재 라운드까지 불가능하다면
                end = mid - 1;
            }
        }
        
        return answer + 1;
    }
    
    public boolean isPossible(int n, int k, int[] enemy, int mid) {
        int tSize = mid + 1;
        if(tSize <= k) return true; // 모든 공격에 무적권을 사용할 수 있는 경우
        
        int[] temp = Arrays.copyOf(enemy, tSize);
        Arrays.sort(temp);
        
        Long total = 0L;
        for(int i = 0; i < tSize - k; i++) {
            total += temp[i];
        }
        
        return total > n ? false : true;
    }
}