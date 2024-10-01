import java.io.*;
import java.util.*;

public class Main {
    static int[] people;
    static ArrayList<Integer> A[];
    static boolean visited[];
    static int answer, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        people = new int[N + 1];
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= cur; j++) {
                A[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        solve();
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void solve() {
        for (int subset = 1; subset < (1 << N) - 1; subset++) {
            Arrays.fill(visited, false);

            for (int i = 0; i < N; i++) {
                if ((subset & (1 << i)) != 0) {
                    visited[i + 1] = true;
                }
            }

            if (isConnected(true) && isConnected(false)) {
                calc();
            }
        }
    }

    static boolean isConnected(boolean flag) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            if (visited[i] == flag) {
                queue.add(i);
                check[i] = true;
                break;
            }
        }

        if (queue.isEmpty()) return false;

        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;

            for (int next : A[cur]) {
                if (!check[next] && visited[next] == flag) {
                    check[next] = true;
                    queue.add(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == flag && !check[i]) {
                return false;
            }
        }

        return true;
    }

    static void calc() {
        int sectorA = 0, sectorB = 0;

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                sectorA += people[i];
            } else {
                sectorB += people[i];
            }
        }

        answer = Math.min(answer, Math.abs(sectorA - sectorB));
    }
}
