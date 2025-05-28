/*
    한자리 숫자가 적힌 종이 조각
    흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있을까
    각 종이 조각에 적인 숫자가 적인 문자열 numbers
    종이 조각으로 만들 수 있는 소수가 몇 개인지 return
    
    1 <= numbers.length() <= 7kkkkkkkkkkkkk
*/
import java.util.*;

class Solution {
    boolean[] isSelected;
    HashSet<Integer> hSet = new HashSet<>();
    
    public int solution(String numbers) {
        isSelected = new boolean[numbers.length()];
        
        for(int cnt = 1; cnt <= numbers.length(); cnt++) {
            perm(numbers, "", 0, cnt);
        }
        
        int answer = 0;
        for(Integer n : hSet) {
            if(isPrimeNumber(n)) {
                answer++;
            }
        }

        return answer;
    }
    
    public void perm(String numbers, String number, int currCnt, int totalCnt) {
        if(currCnt == totalCnt) {
            hSet.add(Integer.parseInt(number));   
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!isSelected[i]) {
                isSelected[i] = true;
                perm(numbers, number+numbers.charAt(i), currCnt+1, totalCnt);
                
                isSelected[i] = false;
            }
        }   
    }
    
    public boolean isPrimeNumber(int number) {
        if(number == 0 || number == 1) return false;
        
        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                return false;
            }
        }

        return true;
    }
}