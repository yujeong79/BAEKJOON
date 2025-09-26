import java.util.*;

/*
    과제는 시작하기로 한 시각이 되면 시작한다.
    새로운 과제를 시작할 시각이 되었을 때, 기존에 진행 중이던 과제가 있다면 진행 중이던 과제를 멈추고 새로운 과제를 시작한다.
    진행 중이던 과제를 끝냈을 때, 잠시 멈춘 과제가 있다면, 멈춰둔 과제를 이어서 진행한다.
    만약, 과제를 끝낸 시각에 새로 시작해야 되는 과제와 잠시 멈춰둔 과제가 모두 있다면, 새로 시작해야 하는 과제부터 진행한다.
    멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제부터 시작한다. -> Stack
    
    과제를 끝낸 순서대로 이름을 배열에 담아 return
*/

class Solution {
    class Assignment {
        String subject;
        int start;
        int playtime;
        
        Assignment(String subject, int start, int playtime) {
            this.subject = subject;
            this.start = start;
            this.playtime = playtime;
        }
    }
    
    public String[] solution(String[][] plans) {
        PriorityQueue<Assignment> pq = new PriorityQueue<>((a1, a2) -> a1.start-a2.start);
        for(String[] plan : plans) {
            StringTokenizer st = new StringTokenizer(plan[1], ":");
            int start = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
            pq.add(new Assignment(plan[0], start, Integer.parseInt(plan[2])));
        }
        
        List<String> answerLst = new ArrayList<>();
        Stack<Assignment> stack = new Stack<>();
        while(!pq.isEmpty()) {
            Assignment curr = pq.poll();
            int end = curr.start + curr.playtime;
            int next = Integer.MAX_VALUE;
            
            if(!pq.isEmpty()) next = pq.peek().start;
            
            if(end <= next) {
                System.out.println(curr.subject + " 완료");
                answerLst.add(curr.subject);
                
                while(!stack.isEmpty() && end < next) {
                    Assignment ongoing = stack.pop();
                    
                    if(end + ongoing.playtime <= next) {
                        end += ongoing.playtime;
                        answerLst.add(ongoing.subject);
                        System.out.println(ongoing.subject + " 완료");
                    } else {
                        ongoing.playtime -= next - end;
                        end = next;
                        stack.add(ongoing);
                        System.out.println(ongoing.subject + " " + ongoing.playtime + "분 남음");
                    }
                }
            }
            
            else if(!pq.isEmpty() && end > next) {
                curr.playtime -= next - curr.start;
                stack.add(curr);
                System.out.println(curr.subject + " " + curr.playtime + "분 남음");
            }
        }
        
        while(!stack.isEmpty()) {
            System.out.println(stack.peek().subject + " 완료");
            answerLst.add(stack.pop().subject);
        }
        
        String[] answer = answerLst.toArray(new String[answerLst.size()]);
        return answer;
    }
}