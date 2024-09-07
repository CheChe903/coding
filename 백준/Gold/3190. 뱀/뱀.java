import java.io.*;
import java.util.*;

public class Main {
    static int N, K, L;
    static int[][] map;
    static boolean[][] snake;
    static Queue<int[]> snakeQ = new LinkedList<>();
    static Map<Integer, Character> dirChange = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        snake = new boolean[N+1][N+1];
        snake[1][1] = true;
        snakeQ.offer(new int[]{1, 1});

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1; // 사과 위치 표시
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            dirChange.put(second, dir);
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0;
        int time = 0;
        int headR = 1, headC = 1;

        while (true) {
            time++;
            int nextR = headR + directions[dirIndex][0];
            int nextC = headC + directions[dirIndex][1];
            if (nextR < 1 || nextR > N || nextC < 1 || nextC > N || snake[nextR][nextC]) {
                break;
            }

            snake[nextR][nextC] = true;
            snakeQ.offer(new int[]{nextR, nextC});

            if (map[nextR][nextC] == 0) {
                int[] tail = snakeQ.poll();
                snake[tail[0]][tail[1]] = false;
            } else {
                map[nextR][nextC] = 0;
            }

            if (dirChange.containsKey(time)) {
                char c = dirChange.get(time);
                if (c == 'L') {
                    dirIndex = (dirIndex - 1 + 4) % 4;
                } else if (c == 'D') {
                    dirIndex = (dirIndex + 1) % 4;
                }
            }

            headR = nextR;
            headC = nextC;
        }

        System.out.println(time);
    }
}