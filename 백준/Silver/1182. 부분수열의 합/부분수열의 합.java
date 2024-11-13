import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main {
	static int N,S,answer;
	static int arr[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N= Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++){ 
			arr[i] = Integer.parseInt(st.nextToken());
		}
		answer =0;
		dfs(0,0);

		if(S ==0 ) answer--;

		System.out.println(answer);

	}
	static void dfs(int depth, int sum) {

		if(depth ==N) {
			if(sum == S) answer++;
			return;
		}

		dfs(depth+1, sum + arr[depth]);
		dfs(depth+1, sum);
	}

}
