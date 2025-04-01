import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hSet = new HashSet<Integer>();
        for(Integer n : nums) {
            hSet.add(n);
        }
        
        return nums.length/2 <= hSet.size() ? nums.length/2 : hSet.size(); 
    }
}