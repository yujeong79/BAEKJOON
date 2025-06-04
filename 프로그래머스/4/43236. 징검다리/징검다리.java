/*
    출발지점부터 distance만큼 떨어진 곳에 도착지점이 있다.
    그 사이에 있는 바위들 중 몇 개를 제거하려고 한다.
    바위 사이의 거리 중 최솟값 중에 가장 큰 값을 return하라.
    
    distance는 1 이상 1_000_000_000 이하이다.
    바위는 1개 이상 50_000개 이하이다.
    n은 1 이상 바위의 개수 이하이다.
    
    조합은 역시 말도 안됨 바로 시간 초과
*/

import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int[] temp = new int[rocks.length+1];
        for(int i = 0; i < rocks.length; i++) temp[i] = rocks[i];
        temp[rocks.length] = distance;
        
        int answer = binarySearch(distance, temp, n);
        return answer;
    }
    
    public int binarySearch(int distance, int[] rocks, int n) {
        int start = 1;
        int end = distance;
        
        int answer = distance;
        while(start <= end) {
            int mid = (start+end)/2;
            
            int res = countRemovedRocks(rocks, n, mid);
            if (res <= n) { // 제거된 바위의 개수가 n과 같은 경우
                start = mid + 1;
                answer = mid;
            } else { // 제거된 바위의 개수가 n 미만인 경우
                end = mid - 1;
            }
        }
        
        return answer;
    }
    
    public int countRemovedRocks(int[] rocks, int n, int mid) {
        int removedRocksCnt = 0;
        
        int curr = 0;
        for(int i = 0; i < rocks.length; i++) {
            if(rocks[i] - curr < mid) { // 현재 기준이 되는 돌부터의 거리가 mid 미만인 경우
                removedRocksCnt++; // 바위 제거
            } else {
                curr = rocks[i]; // mid 이상인 경우 기준이 되는 돌을 갱신
            }
        }
        
        return removedRocksCnt;
    }
}