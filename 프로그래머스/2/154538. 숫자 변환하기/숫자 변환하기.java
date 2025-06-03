import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int MAX = 1_000_001;
        
        int[] arr = new int[y+1];
        Arrays.fill(arr, MAX);
        arr[x] = 0;
        
        for(int curr = x; curr <= y; curr++) {
            if(arr[curr] == MAX) continue;
                
            int plusN = curr + n;
            int multipleTwo = curr * 2;
            int multipleThree = curr * 3;
            
            if(plusN <= y) arr[plusN] = Math.min(arr[curr] + 1, arr[plusN]);
            if(multipleTwo <= y) arr[multipleTwo] = Math.min(arr[curr] + 1, arr[multipleTwo]);
            if(multipleThree <= y) arr[multipleThree] = Math.min(arr[curr] + 1, arr[multipleThree]);
        }

        return arr[y] == MAX ? -1 : arr[y];
    }
}