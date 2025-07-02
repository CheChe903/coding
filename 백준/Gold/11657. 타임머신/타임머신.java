import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int N, M;
    static ArrayList<long[]> A[];
    static long INF = 1_000_000_000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            A[u].add(new long[]{v, w});
        }

        long[] dist = ford(1);
        
        if (dist == null) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    System.out.println("-1");
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }

    static long[] ford(int start) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // 최대 N-1번 릴랙스 수행
        for (int i = 1; i < N; i++) {
            boolean updated = false;
            for (int u = 1; u <= N; u++) {
                if (dist[u] == INF) continue;
                for (long[] edge : A[u]) {
                    int v = (int)edge[0];
                    long w = edge[1];
                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                        updated = true;
                    }
                }
            }
            if (!updated) break; // 더 이상 업데이트가 없으면 조기 종료
        }

        // 음수 사이클 검사
        for (int u = 1; u <= N; u++) {
            if (dist[u] == INF) continue;
            for (long[] edge : A[u]) {
                int v = (int)edge[0];
                long w = edge[1];
                if (dist[u] + w < dist[v]) {
                    return null; // 음수 사이클 존재
                }
            }
        }

        return dist;
    }
}