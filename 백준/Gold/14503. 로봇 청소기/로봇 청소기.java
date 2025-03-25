import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int r, c, d;
    static int[][] arr;
    static int answer = 0;
    // Directions: North(0), East(1), South(2), West(3)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);
        System.out.println(answer);
    }

    static void dfs(int x, int y, int direction) {
        if (!visited[x][y] && arr[x][y] == 0) {
            visited[x][y] = true;
            answer++;
        }

        boolean moved = false;
        for (int i = 0; i < 4; i++) {
            direction = (direction - 1 + 4) % 4;
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && 
                arr[nx][ny] == 0 && !visited[nx][ny]) {
                dfs(nx, ny, direction);
                moved = true;
                break;
            }
        }

        if (!moved) {
            int bx = x - dx[direction];
            int by = y - dy[direction];

            if (bx >= 0 && by >= 0 && bx < N && by < M && arr[bx][by] == 0) {
                dfs(bx, by, direction);
            }
        }
    }
}