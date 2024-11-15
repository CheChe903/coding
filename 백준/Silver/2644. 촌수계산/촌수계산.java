import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer> A[];
	static int visited[];
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine());

		A = new ArrayList[N+1];
		visited = new int[N+1];

		for(int i =1; i<=N; i++) {
			A[i] = new ArrayList<>();
			visited[i] = -1;
		}

		for(int i =1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			A[S].add(E);
			A[E].add(S);
		}
		bfs(start);
		System.out.println(visited[end]);
	}

	static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node]= 0;

		while(!queue.isEmpty()) {
			int now = queue.poll();

			for(int num : A[now]) {
				if(visited[num]== -1) {
					queue.add(num);
					visited[num] = visited[now] +1;
				}
			}
		}
	}
}

