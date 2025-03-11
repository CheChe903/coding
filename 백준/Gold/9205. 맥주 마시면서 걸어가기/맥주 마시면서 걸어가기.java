import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] locations;
    static boolean[] visited;
    static final int MAX_BEER = 20;
    static final int METERS_PER_BEER = 50;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine().trim());
            
            // 0: 집, 1~n: 편의점, n+1: 페스티벌
            locations = new int[n + 2][2];
            visited = new boolean[n + 2];
            
            // 집 좌표 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            locations[0][0] = Integer.parseInt(st.nextToken());
            locations[0][1] = Integer.parseInt(st.nextToken());
            
            // 편의점 좌표 입력
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                locations[i][0] = Integer.parseInt(st.nextToken());
                locations[i][1] = Integer.parseInt(st.nextToken());
            }
            
            // 페스티벌 좌표 입력
            st = new StringTokenizer(br.readLine());
            locations[n + 1][0] = Integer.parseInt(st.nextToken());
            locations[n + 1][1] = Integer.parseInt(st.nextToken());
            
            // BFS 탐색
            if (bfs()) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }
    
    static boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); // 집에서 시작
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            if (current == n + 1) {
                return true;
            }
            
            for (int next = 0; next <= n + 1; next++) {
                if (visited[next]) continue;
                
                int distance = Math.abs(locations[current][0] - locations[next][0]) 
                             + Math.abs(locations[current][1] - locations[next][1]);
                
                if (distance <= MAX_BEER * METERS_PER_BEER) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        
        return false;
    }
}