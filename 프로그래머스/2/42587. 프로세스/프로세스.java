import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        int loc = location;
        for(int i =0; i<priorities.length; i++)
        {
 
            q.offer(priorities[i]);
            pq.offer(priorities[i]);
        }

        while(!q.isEmpty() && !pq.isEmpty() &&true)
        {
            int cur = pq.poll();
            int cur2 = q.peek();
            while(!q.isEmpty() && !pq.isEmpty() &&true)
            {
                cur2= q.poll();
                if(cur2 ==cur)
                    break;
                else
                {
                    q.offer(cur2);
                }
                loc = loc -1;
                if(loc ==-1)
                    loc = q.size()-1;

            }
            answer++;

            if(loc == 0)
                break;
            loc = loc-1;
        }
        // 9 1 1 1 1 1
        // 1 1 1 1 1 
        return answer;
    }
}