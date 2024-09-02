import java.util.*;
import java.io.*;

public class Main {

	static int[] scv;
	static int answer =Integer.MAX_VALUE;
	static boolean[][][] visited = new boolean[61][61][61];

    public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		scv  = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}

		dfs(scv[0],scv[1],scv[2],0);

		System.out.println(answer);
	}

	static void dfs(int a, int b, int c, int count) {
			a = Math.max(0,a);
			b = Math.max(0,b);
			c = Math.max(0,c);


			if(a == 0 && b == 0 && c ==0) {
				answer = Math.min(answer, count);
				return;
			}

			int []sort ={a,b,c};
			Arrays.sort(sort);
			a = sort[2];
			b= sort[1];
			c= sort[0];

			if(visited[a][b][c])
				return;
			else
				visited[a][b][c] = true;
			
			if(answer< count)
				return;

			dfs(a-9, b-3,c-1,count+1);
			dfs(a-9, b-1, c-3, count+1);
			dfs(a-3, b-1, c-9, count+1);
			dfs(a-3, b-9, c-1, count+1);
			dfs(a-1, b-3, c-9, count+1);
			dfs(a-1, b-9, c-3, count+1);

			return;
	}

}
