import java.util.*;

class Solution {
    
    static ArrayList<Integer> list[];
    static boolean visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        list = new ArrayList[n+1];
        
        for(int i =1; i<=n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        visited = new boolean[n+1];
        for(int i =0; i<computers.length; i++) {
            for(int j =0; j<computers[i].length;j++) {
                if(computers[i][j] == 1) {
                    list[i+1].add(j+1);
                    list[j+1].add(i+1);
                }
            }
        }
        
        for(int i =1; i<=n; i++) {
            if(!visited[i]){
                bfs(i);
                answer+=1;
            }
        }
        
        return answer;
    }
    static void bfs(int start) {
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int cur : list[now]) {
                if(!visited[cur]) {
                    queue.add(cur);
                    visited[cur] = true;
                }
            }
        }
    }
}