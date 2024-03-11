import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        answer = new int[2];
        boolean []arr = new boolean[yellow+1];
        
        arr[1]=true;
        
        for(int i =2; i<arr.length; i++)
        {
            if(yellow%i ==0)
                arr[i]=true;
        }
        int left =1;
        int right=arr.length-1;
        int mid =(left+right)/2;
        
        for(int i = left; i<=mid; i++)
        {
            if(arr[i] == true)
            {
                int cur = yellow/i;
                if(i*2 + cur*2 +4==brown)
                {
                    answer[0]=cur+2;
                    answer[1]=i+2;
                    break;
                }
                
            }
        }
        
        return answer;
    }
}