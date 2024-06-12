import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i =0; i<scoville.length; i++)
        {
            pq.add(scoville[i]);
        }
        
        while(pq.size()>=2 && pq.peek() <K)
        {
            int cur = pq.poll();
            int cur2 = pq.poll();
            
            int cur3 = cur2*2 + cur;
            
            pq.add(cur3);
            answer++;
            
            
        }
        if(pq.peek() < K)
            return -1;
        return answer;
    }
}