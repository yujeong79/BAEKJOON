import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int size = numbers.length;
        int[] answer = new int[size];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = size-1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(numbers[i]);
        }
        
        return answer;
    }
}