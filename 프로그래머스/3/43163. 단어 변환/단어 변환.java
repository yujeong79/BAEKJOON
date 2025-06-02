import java.util.*;

class Solution {
    boolean[] isVisited;
    
    public int solution(String begin, String target, String[] words) {
        isVisited = new boolean[words.length];
        
        int answer = bfs(begin, target, words);
        return answer;
    }
    
    public int bfs(String begin, String target, String[] words) {
        int wSize = begin.length(); // 단어의 길이
        
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        
        int res = 0;
        while(!queue.isEmpty()) {
            int qSize = queue.size();
            
            for(int q = 0; q < qSize; q++) {
                String curr = queue.poll();
                if(curr.equals(target)) return res;

                for(int i = 0; i < words.length; i++) { // 변환할 수 있는 단어인지 체크
                    if(!isVisited[i]) {
                        int diffCnt = 0;
                        for(int j = 0; j < wSize; j++) {
                            if(curr.charAt(j) != words[i].charAt(j)) diffCnt++;
                        }

                        if(diffCnt == 1) {
                            queue.add(words[i]);
                            isVisited[i] = true;
                        }
                    }
                }
            }
            
            res++;
        }
        
        return 0;
    }
}