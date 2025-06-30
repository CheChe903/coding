import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 1) 그래프 초기화
        ArrayList<int[]>[] list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        for (int[] f : fares) {
            int u = f[0], v = f[1], w = f[2];
            list[u].add(new int[]{v, w});
            list[v].add(new int[]{u, w});
        }

        int[] distS = dijkstra(n, s, list);
        int[] distA = dijkstra(n, a, list);
        int[] distB = dijkstra(n, b, list);

        int answer = Integer.MAX_VALUE;
        for (int k = 1; k <= n; k++) {
            if (distS[k] == Integer.MAX_VALUE
             || distA[k] == Integer.MAX_VALUE
             || distB[k] == Integer.MAX_VALUE) continue;
            answer = Math.min(answer, distS[k] + distA[k] + distB[k]);
        }

        return answer;
    }

    private int[] dijkstra(int n, int start, ArrayList<int[]>[] graph) {
        final int INF = Integer.MAX_VALUE;
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], cost = cur[1];
            if (cost > dist[u]) continue;

            for (int[] edge : graph[u]) {
                int v = edge[0], w = edge[1];
                if (dist[v] > cost + w) {
                    dist[v] = cost + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }
}
