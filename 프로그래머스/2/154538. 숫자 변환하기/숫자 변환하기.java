import java.util.*;
class Solution {
    static int count;
    public int solution(int x, int y, int n) {
        int answer = 0;
        answer =bfs(x,y,n);
        return answer;
    }
    
    
    public static int bfs(int x, int y, int n)
    {
        Queue<Integer> queue = new LinkedList<>();
        
        HashSet<Integer> set = new HashSet<>();
        int depth =0;
        
        queue.add(x);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i =0; i<size; i++)
            {
                int cur = queue.poll();
                
                if(cur == y)
                    return depth;
                if(!set.contains(cur*2) && cur *2 <=y)
                {
                    queue.add(cur*2);
                    set.add(cur*2);
                }
                if(!set.contains(cur*3) && cur *3 <=y)
                {
                    queue.add(cur*3);
                    set.add(cur*3);
                }
                if(!set.contains(cur+n) && cur+n <=y)
                {
                    queue.add(cur+n);
                    set.add(cur+n);
                }
            }
            depth++;
        }
        
        return -1;
        
    }
}