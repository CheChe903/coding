import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer> A[];
	static boolean visited[][];
	static int answer[][];
	static int N;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		A = new ArrayList[N+1];
		for(int i =1; i<=N; i++) {
			A[i] = new ArrayList<>();
		}

		StringTokenizer st;

		for(int i =1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1; j<=N;j++) {
				int cur = Integer.parseInt(st.nextToken());

				if(cur == 1) {
					A[i].add(j);
				}
			}
		}
		answer = new int[N+1][N+1];
		for(int i =1; i<=N; i++) {
			visited = new boolean[N+1][N+1];
			bfs(i);
		}

		for(int i = 1; i<=N; i++) {
			for(int j =1; j<=N;j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
	}

	static void bfs(int node) {

		Queue<Integer> queue = new LinkedList<>();

		queue.add(node);

		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int num : A[now]) {
				if(visited[node][num]==false) {
					queue.add(num);
					visited[node][num] =true;
					answer[node][num]= 1;
				}
			}
		}

	}


}
