import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int F = Integer.parseInt(st.nextToken()); // total floors
        int S = Integer.parseInt(st.nextToken()); // start floor
        int G = Integer.parseInt(st.nextToken()); // goal floor
        int U = Integer.parseInt(st.nextToken()); // up button
        int D = Integer.parseInt(st.nextToken()); // down button
        
        int[] visited = new int[F + 1];
        Arrays.fill(visited, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        visited[S] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            // Try going up
            if (current + U <= F && visited[current + U] == -1) {
                visited[current + U] = visited[current] + 1;
                queue.offer(current + U);
            }
            
            // Try going down
            if (current - D >= 1 && visited[current - D] == -1) {
                visited[current - D] = visited[current] + 1;
                queue.offer(current - D);
            }
        }
        
        System.out.println(visited[G] == -1 ? "use the stairs" : visited[G]);
    }
}