/**
* 과학자가 발표한 논문 n편 중, h번 이상 인용된 눈문이 h편 이상이고 나머지 논문이 h번 이하 이용되었다면
* h의 최댓값이 이 과학자의 H-Index 이다.
* 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때,
* H-Index를 return 하도록 solution 함수를 작성
**/
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int answer = 0;
        
        int n = citations.length; // 어떤 과학자가 발표한 논문 n편
        int maxCitation = citations[n-1]; // 최대로 인용된 논문이 인용된 수
        for(int h = maxCitation; h >= 0; h--) {
            if(binarySearch(citations, n, h)) return h;      
        }
        
        return 0;
    }
    
    public boolean binarySearch(int[] citations, int n, int h) {
        int start = 0;
        int end = n;
        
        // h의 경계선에 있는 논문의 위치 찾기
        while(start < end) {
            int mid = (start+end)/2;
            
            if(citations[mid] >= h) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        
        if(n - start >= h) 
            return true;
        
        return false;
    }
}