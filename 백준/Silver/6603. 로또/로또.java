import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int result[];
	static boolean visited[];
	static int arr[];
	static int input;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		while(true){
			st = new StringTokenizer(br.readLine());
			input = Integer.parseInt(st.nextToken());

			if(input == 0)
				break;

			arr = new int[input];
			visited= new boolean[input];
			result = new int[6];
			for(int i =0; i<input; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0,0);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int cur, int depth) {
		if(depth ==6) {
			for(int val : result) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = cur; i<input; i++) {
			if(visited[i]==false) {
				visited[i] = true;
				result[depth]= arr[i];
				dfs(i, depth+1);
				visited[i]= false;
			}
		}

	}

}
