import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
 
public class Main {
	static int answer = 0;
	static int N, map[][];
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		StringTokenizer st;
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0,1,0);
		System.out.println(answer);
	}

	static void dfs(int x, int y, int dir) {
		if(x == N-1 && y == N-1) {
			answer+=1;
			return;
		}

		switch (dir) {
			case 0:
				if(y+1 <N && map[x][y+1] ==0)
					dfs(x,y+1, 0);
				break;

			case 1:
				if(x+1 <N && map[x+1][y] ==0)
					dfs(x+1,y,1);
				break;
			case 2:
				if(y+1 <N && map[x][y+1] == 0)
					dfs(x,y+1,0);
				
				if(x+1 <N && map[x+1][y] ==0 )
					dfs(x+1,y,1);
		}
        if (y + 1 < N && x + 1 < N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            dfs(x + 1, y + 1, 2);
        }
	}

}