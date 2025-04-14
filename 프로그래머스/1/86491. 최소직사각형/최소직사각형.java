import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int cardCnt = sizes.length;
        int[] widths = new int[cardCnt];
        int[] heights = new int[cardCnt];
        
        for(int i = 0; i < cardCnt; i++) {
            int width = sizes[i][0];
            int height = sizes[i][1];
            
            if(width > height) {
                widths[i] = width;
                heights[i] = height;
            } else {
                widths[i] = height;
                heights[i] = width;
            }
        }
        
        Arrays.sort(widths);
        Arrays.sort(heights);
        
        int answer = widths[cardCnt-1] * heights[cardCnt-1];
        return answer;
    }
}