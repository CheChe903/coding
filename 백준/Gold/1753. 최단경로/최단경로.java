import java.io.*;
import java.util.*;

import org.w3c.dom.Node;

public class Main {


    static class Node implements Comparable<Node>{
        int end, weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static ArrayList<Node>[] graph;
    static int[] dist;
    static boolean[] visited;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st  =new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(dist, INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        dist[start] = 0;


        while(!pq.isEmpty()) {
            Node currentNode = pq.poll();

            int current = currentNode.end;

            if(visited[current]) continue;
            visited[current] = true;

            for(Node neighnor: graph[current]) {
                if(!visited[neighnor.end] && dist[neighnor.end] > dist[current] + neighnor.weight) {
                    dist[neighnor.end] = dist[current] + neighnor.weight;
                    pq.add(new Node(neighnor.end, dist[neighnor.end]));
                }
            }
        }
    }
}
