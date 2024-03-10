import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        
        answer =new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();        
        
        for(int i =0; i<prices.length; i++)
        {
            queue.add(prices[i]);
        }
        int k =0;
        while(queue.peek() !=null)
        {
            int cur = queue.poll();
            
            answer[k]=0;
            for(Integer a : queue)
            {
                if(cur <=a)
                    answer[k]+=1;
                else
                {
                    answer[k]+=1;
                    break;
                }
                 
            }
            k++;
        }
        
        
        return answer;
    }
}