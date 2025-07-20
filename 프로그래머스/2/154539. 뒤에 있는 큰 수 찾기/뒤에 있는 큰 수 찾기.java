import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int size = numbers.length;
        int[] answer = new int[size];
        Arrays.fill(answer, -1);
        
        for(int i = size-2; i >= 0; i--) {
            for(int j = i+1; j < size; j++) {
                if(numbers[i] >= numbers[j] && answer[j] < 0) break;
                
                if(numbers[i] < numbers[j]) {
                    answer[i] = numbers[j];
                    break;
                }
                
                else if(numbers[i] < answer[j]) {
                    answer[i] = answer[j];
                    break;
                }   
            }
        }
        
        return answer;
    }
}