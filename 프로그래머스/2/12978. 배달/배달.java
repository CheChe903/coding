import java.util.*;

class Edge {
    int e;
    int value;
    
    public Edge(int e, int value) {
        this.e = e;
        this.value = value;
    }
}

class Solution {
    static ArrayList<Edge>[] A;
    static int[] distance;
    static final int INF = 500001; // 제한사항에 주어진 최댓값보다 큰 값으로 초기화

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        A = new ArrayList[N + 1];
        distance = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Edge>();
            distance[i] = INF; // 모든 마을까지의 거리를 최댓값으로 초기화
        }

        for (int i = 0; i < road.length; i++) {
            int S = road[i][0];
            int E = road[i][1];
            int V = road[i][2];
            A[S].add(new Edge(E, V));
            A[E].add(new Edge(S, V)); // 양방향 그래프이므로 반대 방향도 추가
        }

        dijkstra(1);

        // 주어진 시간 내에 도달할 수 있는 마을의 개수 세기
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K)
                answer++;
        }
        return answer;
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        pq.offer(new Edge(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curNode = cur.e;
            int curDist = cur.value;

            if (curDist > distance[curNode]) // 이미 최단 거리가 갱신된 경우 패스
                continue;

            for (Edge next : A[curNode]) {
                int nextNode = next.e;
                int nextDist = curDist + next.value;

                if (nextDist < distance[nextNode]) { // 현재까지의 거리와 새로운 거리를 비교하여 갱신
                    distance[nextNode] = nextDist;
                    pq.offer(new Edge(nextNode, nextDist));
                }
            }
        }
    }
}
