import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int startX, startY, startZ, endX, endY, endZ, L, R, C;
    static int[][][] visited;
    static char[][][] arr;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            arr = new char[L + 1][R + 1][C + 1];
            visited = new int[L + 1][R + 1][C + 1];

            for (int i = 1; i <= L; i++) {
                for (int j = 1; j <= R; j++) {
                    String input = br.readLine();
                    for (int k = 1; k <= C; k++) {
                        arr[i][j][k] = input.charAt(k - 1);
                        if (arr[i][j][k] == 'S') {
                            startX = j; startY = k; startZ = i;
                        }
                        if (arr[i][j][k] == 'E') {
                            endX = j; endY = k; endZ = i;
                        }
                        visited[i][j][k] = -1;
                    }
                }
                br.readLine(); // 각 층마다 빈 줄
            }

            bfs(startX, startY, startZ);

            int result = visited[endZ][endX][endY];
            if (result == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + result + " minute(s).");
            }
        }
    }

    static void bfs(int x, int y, int z) {
        visited[z][x][y] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, z});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0], nowY = now[1], nowZ = now[2];
            int value = visited[nowZ][nowX][nowY];

            for (int i = 0; i < 6; i++) {
                int nx = nowX + dx[i], ny = nowY + dy[i], nz = nowZ + dz[i];
                if (nx >= 1 && nx <= R && ny >= 1 && ny <= C && nz >= 1 && nz <= L) {
                    if (visited[nz][nx][ny] == -1 && arr[nz][nx][ny] != '#') {
                        visited[nz][nx][ny] = value + 1;
                        if (arr[nz][nx][ny] == 'E') return;
                        queue.add(new int[]{nx, ny, nz});
                    }
                }
            }
        }
    }
}
