import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static char arr[][];
    static int answer;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        visited = new boolean[26];  
        answer = 0;
        dfs(0, 0, 1);

        System.out.println(answer);
    }

    static void dfs(int x, int y, int count) {
        visited[arr[x][y] - 'A'] = true;

        if (answer < count) 
            answer = count;

        for (int i = 0; i < 4; i++) {
            int nowx = x + dx[i];
            int nowy = y + dy[i];

            if (nowx >= 0 && nowy >= 0 && nowx < N && nowy < M) {
                if (!visited[arr[nowx][nowy] - 'A']) {
                    dfs(nowx, nowy, count + 1);
                }
            }
        }

        visited[arr[x][y] - 'A'] = false;
    }
}
