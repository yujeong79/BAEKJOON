/**
* 배열 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때 k번째에 있는 수를 구해보자.
**/

/**
* 1 <= array.length <= 100
* 1 <= array[i] <= 100
* 1 <= commands.length <= 50
**/
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int cSize = commands.length;
        int[] answer = new int[cSize];
        
        for(int i = 0; i < cSize; i++) {
            answer[i] = sliceAndSort(array, commands[i]);
        }
        
        return answer;
    }
    
    public static int sliceAndSort(int[] array, int[] command) {
        int[] slicedArray = Arrays.copyOfRange(array, command[0]-1, command[1]);
        Arrays.sort(slicedArray);
        return slicedArray[command[2]-1];
    }
}