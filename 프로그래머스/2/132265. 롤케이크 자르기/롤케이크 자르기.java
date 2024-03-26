import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        
        int[] left = new int[topping.length];
        int[] right = new int[topping.length];        
        Set<Integer> hash = new HashSet<Integer>();
        int answer =0;
        int count =0;
        for(int i =0; i<topping.length; i++)
        {
            if(!hash.contains(topping[i]))
            {
                hash.add(topping[i]);
                count++;
            }
            left[i]=count;
        }
        hash = new HashSet<Integer>();
        count =0;
        for(int i =topping.length-1; i>=0; i--)
        {
            if(!hash.contains(topping[i]))
            {
                hash.add(topping[i]);
                count++;
                
            }
            right[i]=count;
        }
        for(int i =0; i<topping.length-1; i++)
        {
            if(left[i]==right[i+1])
            {
                answer++;
            }
        }
        
        
        return answer;
    }
}