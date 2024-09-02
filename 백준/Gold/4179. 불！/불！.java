import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        Queue<int[]> jQ = new LinkedList<>();
        Queue<int[]> fQ = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);
                if (arr[i][j] == 'J') {
                    jQ.add(new int[]{i, j});
                    arr[i][j] = '.'; 
                } else if (arr[i][j] == 'F') {
                    fQ.add(new int[]{i, j});
                }
            }
        }

        int[][] jVisited = new int[N][M];
        int[][] fireVisited = new int[N][M];

        while (!jQ.isEmpty()) {
            int fLen = fQ.size();
            for (int i = 0; i < fLen; i++) {
                int[] fire = fQ.poll();
                int x = fire[0], y = fire[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == '.' && fireVisited[nx][ny] == 0) {
                        fireVisited[nx][ny] = fireVisited[x][y] + 1;
                        fQ.add(new int[]{nx, ny});
                    }
                }
            }

            int jLen = jQ.size();
            for (int i = 0; i < jLen; i++) {
                int[] jihun = jQ.poll();
                int x = jihun[0], y = jihun[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        System.out.println(jVisited[x][y] + 1);
                        return;
                    }

                    if (arr[nx][ny] == '.' && jVisited[nx][ny] == 0 &&
                            (fireVisited[nx][ny] == 0 || fireVisited[nx][ny] > jVisited[x][y] + 1)) {
                        jVisited[nx][ny] = jVisited[x][y] + 1;
                        jQ.add(new int[]{nx, ny});
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
