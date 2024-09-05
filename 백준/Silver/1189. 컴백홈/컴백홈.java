import java.io.*;
import java.util.*;

public class Main {

    static int N,M,K;
    static char arr[][];
    static int answer;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N=  Integer.parseInt(st.nextToken());
        M=  Integer.parseInt(st.nextToken());
        K=  Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M];

        for(int i =0; i<N; i++) {
            String input = br.readLine();
            for(int j =0; j<M; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        visited[N-1][0]= true;
        dfs(1, N-1,0);

        System.out.println(answer);
    }

    static void dfs(int depth, int x, int y) {

        if(x == 0 && y == M-1) {
            if(depth==K)
                answer++;
            return;
        }

        for(int i =0; i<4; i++) {
            int nx  = x+ dx[i];
            int ny = y + dy[i];

            if(nx >=0 && nx <N && ny >=0 && ny <M) {
                if(visited[nx][ny]==false && arr[nx][ny] != 'T') {
                    visited[nx][ny] = true;
                    dfs(depth+1, nx,ny);
                    visited[nx][ny]= false;

                }

            }


        }


    }
}
