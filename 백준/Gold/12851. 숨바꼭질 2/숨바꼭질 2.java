import java.util.*;
import java.io.*;

public class Main {

    static int answer;
    static int answer2;
    static int[] visited;
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        visited = new int[100002];
        Arrays.fill(visited, Integer.MAX_VALUE); 
        
        bfs(N, K);
        
        System.out.println(answer);
        System.out.println(answer2);
    }

    static void bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 0;
        
        answer = Integer.MAX_VALUE;
        answer2 = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int currentCount = visited[current];

            if (current == target) {
                if (currentCount < answer) {
                    answer = currentCount;
                    answer2 = 1;

                } else if (currentCount == answer) {
                    answer2++;
                }
                continue; 
            }
            
            
            int[] nextStates = {current + 1, current - 1, current * 2};
            for (int next : nextStates) {
                if (next >= 0 && next < visited.length && visited[next] > currentCount) {
                    visited[next] = currentCount + 1;
                    queue.add(next);
                }
            }
        }
    }
}
