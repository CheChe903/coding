import java.util.*;

class Solution {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        A = new ArrayList[n+1];
        
        for(int i =1; i<=n; i++)
        {
            A[i] = new ArrayList<Integer>();
        }
        
        for(int i =0; i<wires.length; i++)
        {
            A[wires[i][0]].add(wires[i][1]);
            A[wires[i][1]].add(wires[i][0]);
        }
        int min= Integer.MAX_VALUE;
        for(int j =1; j<=wires.length; j++)
        {
            for (int i = 0; i < wires.length; i++) {
                int v1 = wires[i][0];
                int v2 = wires[i][1];

                visited = new boolean[n + 1];

                A[v1].remove(Integer.valueOf(v2));
                A[v2].remove(Integer.valueOf(v1));

                int cnt = dfs(1);

                int diff = Math.abs(cnt - (n - cnt));
                min = Math.min(min, diff);

                A[v1].add(v2);
                A[v2].add(v1);
            }
        }
        return min;
    }
    static int dfs(int value)
    {
        visited[value]=true;
        int cnt =1;
        for(int i: A[value])
        {
            if(visited[i]==false)
            {
                cnt+=dfs(i);
            }
        }
        
        return cnt;
    }
}