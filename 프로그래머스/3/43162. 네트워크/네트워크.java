import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int max;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        max =1;
        visited = new boolean[n+1];

        A = new ArrayList[n+1];

        for(int i =1; i<=n; i++)
        {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) { // If there's a connection between i and j
                    A[i+1].add(j+1); // Adjust indices because i and j are zero-based
                }
            }
        }
        
        for(int i =1; i<=n; i++)
        {
            if(visited[i]==false)
            {
                dfs(i);
                answer++;

            }
        }
        return answer;
    }
    static void dfs(int value)
    {
        if(visited[value])
            return;

        Queue<Integer> queue = new LinkedList<>();

        visited[value]=true;
        queue.add(value);

        while(!queue.isEmpty())
        {
            int now =queue.poll();
            max=now;
            for(int i : A[now])
            {
                if(visited[i]==false)
                {
                    visited[i]=true;
                    queue.add(i);
                }
            }
        }
    }
}