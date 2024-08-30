import java.util.*;
import java.io.*;

public class Main {
	static int arr[][];
	static int dx[] = {-1,1 ,0,0};
	static int dy[] = {0,0 ,-1,1};
	static int N,M;

	static int maxSafeZone = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st  = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j ++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		dfs(0);

		System.out.println(maxSafeZone);


	}

	static void dfs(int wallCnt) {

		if(wallCnt == 3) {
			bfs();
			return;
		}


		for(int i =0; i<N; i++) {
			for(int j =0; j<M; j++ ){
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(wallCnt+1);
					arr[i][j] = 0;
				} 
			}
		}
	}

	static void bfs() {
		Queue<int []> queue = new LinkedList<>();


		for(int i=0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(arr[i][j] == 2) {
					queue.add(new int[] { i,j});
				}
			}
		}

		int copyArr[][] = new int[N][M];

		for(int i =0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				copyArr[i][j] = arr[i][j];
			}
		}
		while(!queue.isEmpty()) {
			int [] now = queue.poll();
			int x = now[0];
			int y = now[1];

			for(int k = 0; k<4; k++) {
				int nx = x+ dx[k];
				int ny  = y+ dy[k];

				if(nx >=0 && nx<N && ny>=0 && ny <M) {
					if(copyArr[nx][ny] == 0) {
						queue.add(new int[]{ nx,ny});
						copyArr[nx][ny] = 2;
					}
				}
			}
		}

		curSafeZone(copyArr);
	}

	static void curSafeZone(int[][] copyArr) {
		int safeZone =0;
		for(int i =0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(copyArr[i][j] ==0)
					safeZone++;
			}
		}
		if(maxSafeZone < safeZone) 
			maxSafeZone= safeZone;
	}
}