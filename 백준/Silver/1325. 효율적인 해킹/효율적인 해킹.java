import java.util.*;
import java.io.*;

public class Main {

	static int N,M;

	static boolean[] visited;
	static ArrayList<Integer> A[];
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N+1];

		for(int i =1; i<=N; i++) {
			A[i] = new ArrayList<Integer>();
  		}

		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());

			int S = Integer.parseInt(st.nextToken());

			int E = Integer.parseInt(st.nextToken());
			A[E].add(S);

		}

		int answer = -1;
		ArrayList<Integer> answerList = new ArrayList<>();
		for(int i =1; i<=N; i++) {
			int count = bfs(i);

			if(answer < count) {
				answerList.clear();
				answerList.add(i);
				answer= count;
			}
			else if(answer == count) {
				answerList.add(i);
			}

		}

		for(int a : answerList) {
			System.out.print(a+" ");
		}

	}

	static int bfs(int node) {

		Queue<Integer> q = new LinkedList<>();
		
		visited = new boolean[N+1];
		int count = 1;
		q.add(node);
		visited[node] = true;

		while(!q.isEmpty()) {
			int now = q.poll();


			for(int nownode : A[now]) {
				if(visited[nownode]== false) {
					visited[nownode]= true;
					q.add(nownode);
					count ++;
				}
			}
		}


		return count;
	}

}