import java.io.*;
import java.util.*;

public class Main {

	static int N,M, arr[][], visited[][], startN, startM;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
	
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N+1][M+1];
		visited = new int[N+1][M+1];

		for(int i =1; i<=N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j =1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) {
					startN= i;
					startM = j;
				}
			}
		}
		bfs(startN, startM);
		for(int i =1; i<=N; i++) {
			for(int j =1; j<=M; j++) {
				if(visited[i][j] == 0 && arr[i][j]== 1)
					System.out.print(-1 +" ");
				else
					System.out.print(visited[i][j] +" ");
			}
			System.out.println();
		}
	}

	static void bfs(int startN, int startM) {

		visited[startN][startM] = 0;

		Queue<int[]> queue= new LinkedList<>();
		queue.add(new int[] { startN, startM});

		while(!queue.isEmpty()) {
			int now [] = queue.poll();
			int nowx = now[0];
			int nowy = now[1];

			for(int i =0; i<4; i++) {
				int nx = nowx + dx[i];
				int ny = nowy + dy[i];

				if(nx >=1 && nx <=N && ny <=M && ny>=1 && arr[nx][ny] ==1) {
					if(visited[nx][ny]== 0 || visited[nx][ny] > visited[nowx][nowy]+1) {
						visited[nx][ny] = visited[nowx][nowy] +1;
						queue.add(new int[] {nx,ny});
					}
				}
			}
		}
	}
}