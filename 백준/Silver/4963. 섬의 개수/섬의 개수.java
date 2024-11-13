import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {
	static int arr[][];
	static int dx[] = {-1,-1,-1,0,0,1,1,1};
	static int dy[] = {-1,0,1,-1,1,-1,1,0};
	static boolean[][] visited;
	static int w,h;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if(w==0 && h==0)
				break;


			arr = new int[h][w];
			visited = new boolean[h][w];


			for(int i =0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count =0;

			for(int i =0; i<h; i++) {
				for(int j =0; j<w; j++) {
					if(visited[i][j] == false && arr[i][j]== 1) {
						bfs(i,j);
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	
	}
	static void bfs(int x, int y) {

		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[]{x,y});
		visited[x][y]= true;

		while(!queue.isEmpty()) {
			int now[] = queue.poll();

			int nowx = now[0];
			int nowy = now[1];

			for(int i =0; i<8; i++) {
				int nx = nowx + dx[i];
				int ny = nowy + dy[i];
				if(nx >=0 && nx <h && ny >=0 && ny <w && arr[nx][ny] == 1) {
					if(visited[nx][ny] == false) {
						queue.add(new int[]{nx,ny});
						visited[nx][ny] =true;
					}
				}
			}
		}

	}
}
