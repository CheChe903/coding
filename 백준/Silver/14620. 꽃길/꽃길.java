import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int arr[][];
    static int answer;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 2][N + 2];
        visited = new boolean[N + 2][N + 2];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = Integer.MAX_VALUE;

        for (int i = 2; i <= N - 1; i++) {
            for (int j = 2; j <= N - 1; j++) {
                sol(0, 0, i, j);
            }
        }

        System.out.println(answer);
    }

    static void sol(int count, int cost, int x, int y) {

        if (count == 3) {
            answer = Math.min(answer, cost);
            return;
        }

        if (isValid(x, y)) { 
            visited[x][y] = true;
            int tempCost = arr[x][y];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                visited[nx][ny] = true;
                tempCost += arr[nx][ny];
            }

        
            for (int i = 2; i <= N - 1; i++) {
                for (int j = 2; j <= N - 1; j++) {
                    if (!visited[i][j]) {
                        sol(count + 1, cost + tempCost, i, j);
                    }
                }
            }

            visited[x][y] = false;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                visited[nx][ny] = false;
            }
        }
    }

    static boolean isValid(int x, int y) {
        if (visited[x][y]) return false; 

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (visited[nx][ny]) return false; 
        }
        return true;
    }
}
