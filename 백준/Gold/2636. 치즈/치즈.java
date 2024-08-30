import java.util.*;
import java.io.*;

public class Main {

	static int map [][];
	static int N,M,cheese;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean[][] visited;
	static int time;
	public static void main(String[] args) throws Exception {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cheese=0;
		
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if(map[i][j]== 1)
					cheese++;

			}
		}

		bfs();

	}

	static void bfs() {

		Queue<int []> queue = new LinkedList<>();

		visited= new boolean[N][M];
		queue.add(new int[] { 0,0});

		visited[0][0] = true;
		time++;
		int melted =0;
		while(!queue.isEmpty()) {
			int now[] = queue.poll();

			int x = now[0];
			int y = now[1];
			
			for(int k =0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if(nx >=0 && ny >=0 && nx<N && ny <M){
					if(visited[nx][ny]== false) {
						visited[nx][ny]= true;
						if(map[nx][ny] == 0) {
							queue.add(new int[] {nx,ny});
						}
						else {
							map[nx][ny] = 0;
							melted++;
						}
					}


				}
			}
			
		}

		cheese -= melted;

		if(cheese ==0) {
			System.out.println(time);
			System.out.println(melted);
			return;
		}
		else
			bfs();

	}
}