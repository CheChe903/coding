import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int arr[][];
    static int copyArr[][];
    static int answer;
    static List<int[]> rotations = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        copyArr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            rotations.add(new int[]{r, c, s});
        }

        answer = Integer.MAX_VALUE;

        permute(new ArrayList<>(), new boolean[K]);

        System.out.println(answer);
    }

    static void permute(List<int[]> current, boolean[] visited) {
        if (current.size() == rotations.size()) {
            copyArray();
            for (int[] rotation : current) {
                rotate(rotation[0], rotation[1], rotation[2]);
            }
            countArr();
            return;
        }

        for (int i = 0; i < rotations.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(rotations.get(i));
                permute(current, visited);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }

    static void copyArray() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }
    }

    static void rotate(int r, int c, int s) {
        for (int layer = 1; layer <= s; layer++) {
            int top = r - layer;
            int left = c - layer;
            int bottom = r + layer;
            int right = c + layer;

            int temp = copyArr[top][left];

            for (int i = top; i < bottom; i++) {
                copyArr[i][left] = copyArr[i + 1][left];
            }

            for (int i = left; i < right; i++) {
                copyArr[bottom][i] = copyArr[bottom][i + 1];
            }

            for (int i = bottom; i > top; i--) {
                copyArr[i][right] = copyArr[i - 1][right];
            }
            for (int i = right; i > left + 1; i--) {
                copyArr[top][i] = copyArr[top][i - 1];
            }

            copyArr[top][left + 1] = temp;
        }
    }

    static void countArr() {
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < M; j++) {
                count += copyArr[i][j];
            }
            answer = Math.min(answer, count);
        }
    }
}
