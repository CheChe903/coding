import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,E;
    static ArrayList<int []> A[];
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        E = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];

        for(int i =1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i =0; i<E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            A[u].add(new int[] {v,w});
            A[v].add(new int[] {u,w});
        }
        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long d1 = dijstra(1, v1);
        long d2 = dijstra(v1, v2);
        long d3 = dijstra(v2, N);
        long routeA = (d1 >= INF || d2 >= INF || d3 >= INF) ? INF : d1 + d2 + d3;

        // 경로 B: 1 → v2 → v1 → N
        long e1 = dijstra(1, v2);
        long e2 = dijstra(v2, v1);
        long e3 = dijstra(v1, N);
        long routeB = (e1 >= INF || e2 >= INF || e3 >= INF) ? INF : e1 + e2 + e3;

        long answer = Math.min(routeA, routeB);
        System.out.println(answer >= INF ? -1 : answer);
    }

    static long dijstra(int startNode, int endNode) {

        PriorityQueue<long []> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));

        pq.add(new long[] {startNode, 0});

        long diff[] = new long[N+1];

        Arrays.fill(diff, Integer.MAX_VALUE);

        diff[startNode] = 0;

        while(!pq.isEmpty()) {
            long now[] = pq.poll();

            int currentNode = (int) now[0];
            long currentValue = now[1];

            if(currentValue > diff[currentNode]) {
                continue;
            }

            for(int next[] : A[currentNode]) {
                int nextNode = next[0];
                int nextValue = next[1];

                if(diff[nextNode] > currentValue + nextValue) {
                    diff[nextNode] = currentValue + nextValue;
                    pq.add(new long[] { nextNode, diff[nextNode]});
                }
            }
        }

        return diff[endNode];
    }
}
