import java.io.*;
import java.util.*;

public class Main {
    static long result_min = Integer.MAX_VALUE;
    static int N, W[][];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        N = Integer.parseInt(br.readLine());


        W = new int[N+1][N+1];
        visited = new boolean[N+1];
 
        StringTokenizer st;

        for(int i =1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[1] = true;

        dfs(1,1,0);

        System.out.println(result_min);
    }

    static void dfs(int start, int now, long cost) {
        if(allVisited()) {
            if(W[now][start] !=0 ) {
                result_min = Math.min(result_min, cost+ W[now][start]);
            }
            return;
        }

        if(cost >= result_min) return;


        for(int i =1; i<=N; i++) {
            if(visited[i] == false && W[now][i] !=0) {
                visited[i]= true;
                dfs(start,i, cost + W[now][i]);
                visited[i] = false;
            } 
        }
    }
    static boolean allVisited() {
        for(int i =1; i<=N; i++) {
            if(visited[i] == false)
                return false;
        }

        return true;
    }
}