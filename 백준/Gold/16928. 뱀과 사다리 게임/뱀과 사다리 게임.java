import java.io.*;
import java.util.*;

public class Main {
    static int [] board;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        board = new int[101];

        for(int i = 1; i <=100; i++) {
            board[i] = i;
        }

        for(int i = 1; i<= n+k; i++) {
            st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());

            board[x] = y;
        }
        visited = new int[101];
        int result = bfs(1);

        System.out.println(result);

    }

    static int bfs(int startNode) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
    
        while(!queue.isEmpty()) {
            int nowNode = queue.poll();

            for(int i =1; i<=6; i++) {
                int newNode = nowNode+i;

                if(newNode > 100) {
                    continue;
                }
                if(visited[board[newNode]] == 0) {
                    queue.add(board[newNode]);
                    visited[board[newNode]] = visited[nowNode]+1;
                }
                if(board[newNode] == 100) {
                    return visited[100];
                }
            }
        }

        return -1;
    }
}