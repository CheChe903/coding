import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i =0; i<works.length; i++)
        {
            pq.add(works[i]);
        }
        
        for(int i =0; i<n; i++)
        {
            if(pq.peek() >0)
            {
                int temp = pq.poll();
                pq.add(temp-1);
            }
            else
                return 0;
        }
        
        while(!pq.isEmpty())
        {
            int temp = pq.poll();
            answer += temp * temp;
        }
        
        return answer;
    }
}