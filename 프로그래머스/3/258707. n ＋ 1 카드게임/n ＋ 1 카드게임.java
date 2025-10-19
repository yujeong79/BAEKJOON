import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length; // 카드 개수
        HashSet<Integer> original = new HashSet<>(); // 최초로 가진 카드를 위한 Set
        HashSet<Integer> additional = new HashSet<>(); // 추가로 뽑은 카드를 위한 Set
        for(int i = 0; i < n/3; i++) {
            original.add(cards[i]);
        }
        
        int round = 0;
        int idx = n/3;
        while(true) {
            round++;
            
            if(idx >= n) { // 더 이상 뽑을 카드가 없으면 게임 종료
                break;
            }

            additional.add(cards[idx]);
            additional.add(cards[idx+1]);
            
            boolean isPossible = false;
            
            for(int card : original) { // 코인 0개 사용
                if(original.contains(n+1-card)) {
                    original.remove(card);
                    original.remove(n+1-card);
                    
                    isPossible = true;
                    break;
                }
            }

            if(!isPossible && coin >= 1) { // 코인 1개 사용
                for(int card : original) {
                    if(additional.contains(n+1-card)) {
                        original.remove(card);
                        additional.remove(n+1-card);
                        
                        coin--;
                        isPossible = true;
                        break;
                    }
                }
            }

            if(!isPossible && coin >= 2) { // 코인 2개 사용
                for(int card : additional) {
                    if(additional.contains(n+1-card)) {
                        additional.remove(card);
                        additional.remove(n+1-card);
                        
                        isPossible = true;
                        coin -= 2;
                        break;
                    }
                }
            }
            
            if(!isPossible) {
                break;
            }
            
            idx += 2;
        }
        
        return round;
    }
}