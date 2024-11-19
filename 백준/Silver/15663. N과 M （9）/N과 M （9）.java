import java.util.*;
import java.io.*;

public class Main {
	static HashSet<String> set;
	static int N,M;
	static int arr[];
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N  = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		visited = new boolean[N];


		st =  new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		set=  new HashSet<>();

		for(int i =0; i<N; i++) {
			dfs(i, 0, new StringBuilder());
		}
	}

	static void dfs(int idx, int depth, StringBuilder sb) {
		if(depth == M) {
			if(!(set.contains(sb.toString()))) {
				System.out.println(sb);
				set.add(sb.toString());
			}
			return;
		}
		

		for(int i = 0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				int len = sb.length();
				sb.append(arr[i]).append(" ");
				dfs(i, depth+1, sb);
				sb.setLength(len);
				visited[i]= false;
			}
		}
	}

}
