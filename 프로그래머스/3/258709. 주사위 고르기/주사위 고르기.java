/*  
    1. A가 가져갈 주사위 조합의 수 => 최대 252가지
        2 ≤ 주사위의 개수 ≤ 10 => 10C5 => 252
        1 ≤ 주사위 각 면에 적힌 숫자 ≤ 100
    
    2. A/B가 가져간 주사위의 합의 조합 => 6*6*6*6*6 => 7776가지
    3. 둘의 합 조합을 비교... 
    
    완전 탐색 가능할거같기도 하고...
*/

import java.util.*;

class Solution {
    int halfN; // A와 B가 각각 가지는 주사위의 수
    boolean[] isSelectedByA;
    int[][] dices;
    int[] answer;
    int maxWinCnt;
    HashSet<Integer> aSet;
    int[] aNums;
    HashSet<Integer> bSet;
    int[] bNums;
    
    public int[] solution(int[][] dice) {
        dices = dice;
        halfN = dice.length / 2;
        isSelectedByA = new boolean[dice.length];
        answer = new int[halfN];
        maxWinCnt = 0;
        
        // 1. A와 B 주사위 나누기
        comb(0, 0); 
        return answer;
    }
    
    public void comb(int idx, int cnt) {
        if(cnt == halfN) {
            round();
            return;
        }
        
        for(int i = idx; i < halfN*2; i++) {
            if(!isSelectedByA[i]) {
                isSelectedByA[i] = true;
                comb(i+1, cnt+1);
            }
            
            isSelectedByA[i] = false;
        }
    }
    
    public void round() {
        aSet = new HashSet<>();
        bSet = new HashSet<>();
        aNums = new int[501];
        bNums = new int[501];
        
        calculateSum(true, 0, 0, 0); // A의 주사위를 굴린 뒤 모든 점수 계산
        calculateSum(false, 0, 0, 0); // B의 주사위를 굴린 뒤 모든 점수 계산
        
        int currWinCnt = countWin(); // A의 승리 횟수
        // System.out.println(currWinCnt);
        
        if(maxWinCnt < currWinCnt) {
            maxWinCnt = currWinCnt;
            
            int idx = 0;
            for(int i = 0; i < dices.length; i++) {
                if(isSelectedByA[i]) {
                    answer[idx++] = i + 1;
                }
            }
        }
    }
    
    public int countWin() {
        int result = 0;
        
        for(int a : aSet) {
            for(int b : bSet) {
                if(a > b) {
                    result += aNums[a]*bNums[b];
                }
            }
        }
        
        return result;
    }
    
    public void calculateSum(boolean owner, int d, int sum, int cnt) {
        if(cnt == halfN) {
            if(owner) {
                aSet.add(sum);
                aNums[sum]++;
            }
            
            else {
                bSet.add(sum);
                bNums[sum]++;
            }
            
            return;
        }
        
        // 현재 주사위가 owner의 주사위인 경우
        if(isSelectedByA[d] == owner) { 
            for(int i = 0; i < 6; i++) {
                calculateSum(owner, d+1, sum+dices[d][i], cnt+1);    
            }
        }
        
        // 현재 주사위가 owner의 주사위가 아닌 경우
        else {
            calculateSum(owner, d+1, sum, cnt);
        }
    }
}