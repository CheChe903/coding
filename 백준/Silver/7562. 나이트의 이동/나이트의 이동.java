import java.util.*;
import java.io.*;

public class Main {
	static int visited[][];
	static int arr[][];
	static int dx[] ={-1, -2, -2,-1, 1,2,2,1};
	static int dy[] = {-2,-1,1,2,-2,-1,1,2};
	static int I,startX,startY,endX,endY;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for(int i=0;i <T; i++) {
			I = Integer.parseInt(br.readLine());
			arr = new int[I][I];
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			visited = new int[I][I];
			if(startX == endX && startY == endY) {
				sb.append(0).append("\n");
			}
			else
				sb.append(bfs(startX,startY)).append("\n");
		}
		System.out.println(sb);
	}

	static int bfs(int x, int y) {

		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] {x,y});
		visited[x][y]=0;

		while(!queue.isEmpty()) {

			int size = queue.size();

			int now[] = queue.poll();
			int nowx = now[0];
			int nowy = now[1];

			for(int i=0; i< 8; i++) {
				int nx = nowx + dx[i];
				int ny = nowy + dy[i];
				if(nx >=0&& nx <I && ny >=0 && ny <I) {
					if(visited[nx][ny] ==0) {
						visited[nx][ny] = visited[nowx][nowy]+1;
						queue.add(new int[]{nx,ny});
						if(nx == endX && ny == endY) {
							return visited[nx][ny];
						}
					}				
				}
			}

		}
		return -1;
	}

}
