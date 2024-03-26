import java.util.*;
class Solution {
    static ArrayList<Integer>[] A;
    static boolean visited[];
    static int count;
    public int solution(int[] cards) {
        int answer = 0;
        
        A = new ArrayList[cards.length+1];
        
        for(int i =1; i<cards.length+1; i++)
        {
            A[i] = new ArrayList<Integer>();
        }
        
        for(int i =0; i<cards.length; i++)
        {

            A[cards[i]].add(cards[cards[i]-1]);
        }
        int first =0;
        int second =0;
        visited= new boolean[cards.length+1];
        for(int i =1; i<=cards.length; i++)
        {
            count =0;

            if(visited[i]==false)
            {

                bfs(cards[i-1]);
                if(count>=first)
                {
                    second=first;
                    first =count;
                }
                else if(count>=second)
                {
                    second=count;
                }
            }

        }
        answer = first*second;
        return answer;
    }
    
    static void bfs(int v)
    {
        Queue<Integer> queue =new LinkedList<>();
        
        queue.add(v);
        
        visited[v]= true;
        count++;
        while(!queue.isEmpty())
        {
            
            int now = queue.poll();
            
            for(int i : A[now])
            {
                if(visited[i]==false)
                {
                    

                    queue.add(i);
                    visited[i]=true;
                    count++;
                }
            }

        }
        
    }
}