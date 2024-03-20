import java.util.*;

class Solution {
    static ArrayList<Integer>[] A;
    static ArrayList<Integer>[] B;
    static int myn;
    static boolean visited[];
    static int count;
    static int count2;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        myn = n;
        A = new ArrayList[n + 1];
        B = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<Integer>();
            B[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < results.length; i++) {
            A[results[i][0]].add(results[i][1]);
            B[results[i][1]].add(results[i][0]);
        }
        
        for (int i = 1; i <= n; i++) {
            count = 0;
            count2 = 0;
            visited = new boolean[n + 1];
            BFS(i);
            if (count + count2 == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(v);
        visited[v] = true;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int num : A[now]) {
                if (!visited[num]) {
                    count++;
                    queue.add(num);
                    visited[num] = true;
                }
            }
        }
        
        queue.clear();
        queue.add(v);
        visited[v] = true;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int num : B[now]) {
                if (!visited[num]) {
                    count2++;
                    queue.add(num);
                    visited[num] = true;
                }
            }
        }
    }
}
