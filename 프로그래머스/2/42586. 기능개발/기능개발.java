import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> answerQueue = new LinkedList<>();
        
        int funcionCnt = progresses.length;
        for(int i = 0; i < funcionCnt; i++) {
            int leftDays = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) leftDays += 1;
            
            queue.add(leftDays);
        }
        
        while(!queue.isEmpty()) {            
            int curr = queue.poll();
            int deployCnt = 1;
            
            while(queue.size() > 0 && curr >= queue.peek()) {
                queue.poll();
                deployCnt++;
            }
            
            answerQueue.add(deployCnt);
        }
        
        // System.out.println(answerQueue.toString());
        
        int answerSize = answerQueue.size();
        int[] answer = new int[answerSize];
        for(int i = 0; i < answerSize; i++) {
            answer[i] = answerQueue.poll();
            // System.out.println(answer[i]);
        }
        
        return answer;
    }
}