import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i =0; i<operations.length; i++)
        {
            String oper =  operations[i];
            
            if(oper.charAt(0)=='I')
            {
                pq1.add(Integer.parseInt(oper.substring(2)));
                pq2.add(Integer.parseInt(oper.substring(2)));
            }
            else if(oper.charAt(0)=='D')
            {
                if(!pq2.isEmpty()&&!pq1.isEmpty()&&oper.charAt(2)=='-')
                {
                    pq2.remove(pq1.poll());
  
                }
                else if(!pq1.isEmpty() &&!pq2.isEmpty()&&oper.charAt(2)=='1')
                {
                    
                    pq1.remove(pq2.poll());
                }
            }
        }
        answer = new int[2];
        
        if(!pq2.isEmpty())
        {
            answer[0]=pq2.peek();
        }
        else
            answer[0]=0;
        if(!pq1.isEmpty())
        {
            answer[1]=pq1.peek();
        }
        else
            answer[0]=0;
        return answer;
    }
}