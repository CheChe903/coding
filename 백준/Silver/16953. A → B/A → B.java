import java.util.*;
import java.io.*;

public class Main {
	static long answer =Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());

		dfs(0,A,B);
		if(answer == Long.MAX_VALUE) {
			System.out.println(-1);
			System.exit(0);
		}
		System.out.println(answer+1);
	}

	static void dfs(long depth, long start, long end) {
		if(start == end ){
			if(depth < answer)
				answer =depth;

			return;
		}
		if(start > end) {
			return ;
		}

		dfs(depth+1, start*10+1, end);
		dfs(depth+1, start*2, end);
	}
}
