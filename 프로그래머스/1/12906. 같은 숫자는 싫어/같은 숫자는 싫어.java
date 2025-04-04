import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(arr[0]);
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i-1]) {
                queue.add(arr[i]);
            }
        }
        
        int qSize = queue.size();
        int[] answer = new int[qSize];
        
        for(int i = 0; i < qSize; i++) {
            answer[i] = queue.poll();
        }

        return answer;
    }
}