import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;
    static int shark, sharkX, sharkY;
    static int currentEat;
    static int answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Pair {
        int x, y, dist;

        Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        shark = 2;
        currentEat = 0;
        answer = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    arr[i][j] = 0;
                }
            }
        }

        while (true) {
            Pair target = bfs();
            if (target == null) break;

            sharkX = target.x;
            sharkY = target.y;
            answer += target.dist;
            arr[sharkX][sharkY] = 0;

            currentEat++;
            if (currentEat == shark) {
                shark++;
                currentEat = 0;
            }
        }

        System.out.println(answer);
    }

    static Pair bfs() {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new Pair(sharkX, sharkY, 0));
        visited[sharkX][sharkY] = true;

        List<Pair> fishes = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && arr[nx][ny] <= shark) {
                    visited[nx][ny] = true;
                    int newDist = current.dist + 1;

                    if (arr[nx][ny] > 0 && arr[nx][ny] < shark) {
                        if (newDist < minDist) {
                            fishes.clear();
                            fishes.add(new Pair(nx, ny, newDist));
                            minDist = newDist;
                        } else if (newDist == minDist) {
                            fishes.add(new Pair(nx, ny, newDist));
                        }
                    }

                    queue.add(new Pair(nx, ny, newDist));
                }
            }
        }

        if (fishes.isEmpty()) {
            return null;
        }
        Collections.sort(fishes, (a, b) -> {
            if (a.x == b.x) return a.y - b.y;
            return a.x - b.x;
        });

        return fishes.get(0);
    }
}
