/**
* 우선순위 : 소요 시간 > 요청 시각 > 작업 번호
* idx(작업 번호) : [요청 시각, 소요 시간]
**/
import java.util.*;

class Solution {
    class Work implements Comparable<Work> {
        int workNum;
        int requestTime;
        int workHours;
        
        public Work (int workNum, int requestTime) {
            this.workNum = workNum;
            this.requestTime = requestTime;
        }
        
        @Override
        public int compareTo(Work other) {
            if(this.workHours == other.workHours) { 
                if(this.requestTime == other.requestTime) return this.workNum - other.workNum; // 우선순위3: 작업번호
                else return this.requestTime - other.requestTime; // 우선순위2: 요청시각
            }
                
            return this.workHours - other.workHours; // 우선순위1: 소요시간
        }
        
        @Override
        public String toString() {
            return "작업 번호 " + this.workNum + "의 요청 시각: " + this.requestTime + ", 소요 시간: " + workHours;
        }
    }
    
    public int solution(int[][] jobs) {
        PriorityQueue<Work> requestQueue = new PriorityQueue<>();
        PriorityQueue<Work> waitingQueue = new PriorityQueue<>();
        
        // 요청 시각순으로 정렬된 requestQueue 생성
        for(int i = 0; i < jobs.length; i++) {
            requestQueue.add(new Work(i, jobs[i][0]));
        }
        
        int answer = 0;
        int currTime = 0;
        // 작업이 없거나 끝난 경우 대기 큐의 peek 작업 시작
        // - 대기 큐에 작업이 없는 경우 현재 시각 ++
        
        while(!requestQueue.isEmpty() || !waitingQueue.isEmpty()) { // 종료 조건 : 요청 큐와 대기 큐 둘 다 비었을 경우
            while(!requestQueue.isEmpty() && currTime >= requestQueue.peek().requestTime) { // 작업의 요청 시각이 현재 시각보다 작거나 같은 경우
                Work requestedWork = requestQueue.poll();
                requestedWork.workHours = jobs[requestedWork.workNum][1];
                waitingQueue.add(requestedWork); // 대기 큐에 추가
            }
            
            if(!waitingQueue.isEmpty()) { // 대기 큐가 비어 있지 않다면
                Work currWork = waitingQueue.poll();
                
                currTime += currWork.workHours; // 작업 종료 시각
                answer += currTime - currWork.requestTime; // 반환 시간 누적
                System.out.println(answer);
            }
            
            else { // 대기 큐가 비어 있다면
                currTime++; // 현재 시간 증가
            }

        }
        
        return answer / jobs.length;
    }
}