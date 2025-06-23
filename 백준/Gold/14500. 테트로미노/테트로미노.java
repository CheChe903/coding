import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int arr[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static boolean visited[][];
    static int answer = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        for(int i =0; i<N; i++) {
            for(int j =0; j<M; j++) {
                visited[i][j] = true;
                dfs(i,j, arr[i][j], 1);
                visited[i][j]= false;
            }
        }
        System.out.println(answer);
    }

    static void dfs(int x, int y, int sum, int count) {

        if(count ==4) {
            answer = Math.max(sum, answer);
            return;
        }

        for(int i = 0; i<4; i++) {
            int nowx = x +dx[i];
            int nowy = y + dy[i];

            if(nowx >=0 && nowx <N && nowy >=0 && nowy <M) {
                if(!visited[nowx][nowy]) {

                    if(count ==2) {
                        visited[nowx][nowy] = true;
                        dfs(x,y, sum+arr[nowx][nowy], count+1);
                        visited[nowx][nowy] = false;
                    }

                    visited[nowx][nowy] = true;
                    dfs(nowx, nowy, sum+arr[nowx][nowy], count+1);
                    visited[nowx][nowy]= false;
                }
            }

        }
    }
}
