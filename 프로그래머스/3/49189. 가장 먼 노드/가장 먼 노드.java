import java.util.*;

class Solution {
    static ArrayList<Integer>[] A;
    static int[] visited;
    static int count;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        A= new ArrayList[n+1];
        
        for(int i=1; i<=n; i++)
        {
            A[i] = new ArrayList<Integer>();
        }
        
        for(int i =0; i<edge.length; i++)
        {
            A[edge[i][0]].add(edge[i][1]);
            A[edge[i][1]].add(edge[i][0]);
        }
        count =0;
        visited = new int[n+1];
        BFS(1);
        int max =-1;
        for(int i =1; i<=n; i++)
        {
            if(max<visited[i])
            {
                answer=1;
                max=visited[i];
            }
            else if(max == visited[i])
                answer++;
        }
        return answer;
    }
    static void BFS(int v)
    {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(v);
        
        visited[v]= -1;
        
        while(!queue.isEmpty())
        {
            
            int size =queue.size();
            for(int i =0; i<size; i++)
            {
                int now = queue.poll();
                for(int num : A[now])
                {
                    if(visited[num] ==0)
                    {
                        queue.add(num);
                        visited[num]=count+1;
                    }
                }
            }
            count++;
        }
    }
}