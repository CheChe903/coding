import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


	static class Edge {
		int end;
		int cost;

		public Edge(int end, int cost) {
			this.end =end;
			this.cost =cost;
		}
	}

	static class Node {
		int vertex;
		int weight;

		public Node(int vertex, int weight) {
			this.vertex= vertex;
			this.weight =weight;
		}
	}

	static int N,M;
	static List<Edge> edges[];
	static int [] dist;
	static final int INF = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

		edges = new ArrayList[N+1];
		dist = new int[N+1];

		for(int i =1; i<=N; i++) {
			edges[i]= new ArrayList<>();
			dist[i] = INF;
		}

		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			edges[start].add(new Edge(end, value));
			edges[end].add(new Edge(start, value));
		}

		dijkstra(1);
		        if (dist[N] == INF) {
            System.out.println("-1");
        } else {
            System.out.println(dist[N]);
        }

	
	}

	static void dijkstra(int start) {

		boolean[] visited = new boolean[N+1];
		dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));

		pq.add(new Node(start, 0));

		while(!pq.isEmpty()) {
			Node cur = pq.poll();

			int vertex = cur.vertex;
			int weight = cur.weight;

			if(visited[vertex]) continue;
			visited[vertex] = true;

			if(weight > dist[vertex]) continue;

			for(Edge next : edges[vertex]) {
				int v= next.end;
				int cost = next.cost;

				if(!visited[v] && dist[vertex] != INF && dist[vertex] + cost <dist[v]) {
					dist[v] = dist[vertex] + cost;
					pq.offer(new Node(v, dist[v]));
				}
			}
		}
	}
}
