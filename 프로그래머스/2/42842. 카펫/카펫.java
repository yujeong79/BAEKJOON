/*
    중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫
    노란색과 갈색으로 색칠된 격자의 개수는 기억하지만 전체 카펫의 크기는 기억을 못 함
    갈색 격자의 수와 노란색 격자의 수가 주어질 때 가로, 세로 크기를 순서대로 배열에 담아 Return
*/

class Solution {
    public int[] solution(int brown, int yellow) {
        for(int n = 1; n <= yellow; n++) {
            if(yellow % n == 0) {
                if(countBrown(n, yellow/n, brown, yellow)) {
                    if(n >= yellow/n) {
                        return new int[] {n+2, yellow/n+2};
                    }
                }
            }
        }
        
        int[] answer = {};
        return answer;
    }
    
    public boolean countBrown(int n1, int n2, int brown, int yellow) {
        if((n1+2) * (n2+2) - yellow == brown) {
            return true;
        }    
        
        return false;
    }
}