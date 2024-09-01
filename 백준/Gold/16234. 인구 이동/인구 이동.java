import java.util.*;
import java.io.*;

public class Main {

    static int N, L, R;
    static int arr[][];
    static boolean visited[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean check = true;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (!bfs(i, j)) { 
                            check = false;
                        }
                    }
                }
            }

            if (check)
                break;

            answer++;
        }

        System.out.println(answer);
    }

    static boolean bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        int count = arr[x][y];
        q.add(new int[]{x, y});
        q2.add(new int[]{x, y});
        visited[x][y] = true;

        boolean check = true;
        int numCells = 1; 

        while (!q.isEmpty()) {

            int[] now = q.poll();
            int nowx = now[0];
            int nowy = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowx + dx[i];
                int ny = nowy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && Math.abs(arr[nowx][nowy] - arr[nx][ny]) >= L && Math.abs(arr[nowx][nowy] - arr[nx][ny]) <= R) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        q2.add(new int[]{nx, ny});
                        count += arr[nx][ny];
                        numCells++;
                        check = false; 
                    }
                }
            }
        }

        int newPopulation = count / numCells; 

        while (!q2.isEmpty()) {
            int[] now = q2.poll();
            int nowx = now[0];
            int nowy = now[1];
            arr[nowx][nowy] = newPopulation;  
        }

        return check;
    }
}
