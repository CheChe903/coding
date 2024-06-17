import java.util.*;

class Solution {
    static ArrayList<Integer>[] list;
    static int [] visited;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};
        int len = sources.length;
        answer = new int[len];
        list = new ArrayList[n+1];
        
        for(int i =1; i<=n; i++)
        {
            list[i] = new ArrayList<Integer>();
        }
        
        visited =new int[n+1];
        
        for(int i =0; i<roads.length; i++)
        {
            int s = roads[i][0];
            int e = roads[i][1];
            
            list[s].add(e);
            list[e].add(s);
        }
        
        bfs(destination);
        for(int i =0; i< sources.length; i++)
        {
            answer[i] = visited[sources[i]]-1;
        }
        
        return answer;
    }
    
    public void bfs(int n)
    {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(n);
        
        visited[n]=1;
        
        while(!queue.isEmpty())
        {
            int now = queue.poll();
            
            for(int i: list[now])
            {
                if(visited[i] == 0)
                {
                    queue.add(i);
                    visited[i] = visited[now]+1;
                }

            }
        }
        
    }
}