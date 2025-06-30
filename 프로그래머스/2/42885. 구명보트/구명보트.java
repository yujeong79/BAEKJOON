/*
    구명보트를 최대한 적게 사용하여 모든 사람을 구출
    1 <= 무인도에 갇힌 사람 수 <= 50,000
    40 <= 각 사람의 몸무게 <= 240
    40 <= 구명보트 무게 제한 <= 240
*/

import java.util.*;

class Solution {
    
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int answer = 0;
        
        int l = 0;
        int r = people.length - 1;
        while(l <= r) {
            if(l == r || people[l] + people[r] > limit) {
                answer++;
                r--;
            }
            
            else if (people[l] + people[r] <= limit) {
                l++; r--;
                answer++;
            }
        }

        return answer;
    }
 }