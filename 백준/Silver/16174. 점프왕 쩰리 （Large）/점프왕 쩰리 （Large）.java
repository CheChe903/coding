import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int arr[][];
    static int N;
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;
        for(int i = 0;i <N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j ++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0,0);
        if(visited[N-1][N-1] == true) {
            System.out.println("HaruHaru");
        }
        else 
            System.out.println("Hing");
    }

    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});
        visited[startX][startY] = true;
        
        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            int nowx = now[0];
            int nowy = now[1];
            int d = arr[nowx][nowy];
            
            if(nowx + d < N) {
                if(!visited[nowx+d][nowy]) {
                    queue.add(new int[] {nowx+d, nowy});
                    visited[nowx+d][nowy] = true;
                }
            }
            
            if(nowy + d < N) {
                if(!visited[nowx][nowy+d]) {
                    queue.add(new int[] {nowx, nowy+d});
                    visited[nowx][nowy+d] = true;
                }
            }
        }
    }
}