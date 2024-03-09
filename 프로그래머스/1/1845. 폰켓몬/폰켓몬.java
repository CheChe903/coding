import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        
        for(int i =0; i<nums.length; i++)
        {
            hash.put(nums[i],hash.get(nums[i]+1));
            
        }
        for(Integer key : hash.keySet()) {
            answer++;
    }
        if(nums.length/2 <answer)
        {
            answer = nums.length/2;
        }
        return answer;
    }
}