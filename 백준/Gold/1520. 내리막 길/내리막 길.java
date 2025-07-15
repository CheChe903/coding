import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

    static int N,M, arr[][], dp[][];

    static int dx[] = { -1,1,0,0};
    static int dy[] = { 0,0,-1,1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        dp =  new int[N+1][M+1];

        for(int i =1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<=M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(1, 1));
    }

    static int dfs(int x, int y) {
        if(x == N && y ==M) {
            return 1;
        }

        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;

        for(int i =0; i<4; i++) {
            int nowx = x + dx[i];
            int nowy = y + dy[i];

            if(nowx < 1 || nowy < 1 || nowx >N || nowy >M) {
                continue;
            }

            if(arr[x][y]  > arr[nowx][nowy]) {
                dp[x][y] += dfs(nowx, nowy);
            }
        }

        return dp[x][y];

    }
}