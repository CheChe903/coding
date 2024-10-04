import java.io.*;
import java.util.*;

public class Main {
    
    static int dx[] = { -1,1,0,0};
    static int dy[] = { 0,0,-1,1};
    static int arr[][];
    static int rupee[][];
    static StringBuilder sb;
    static int N;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        int problemIndex =1;
        StringTokenizer st;
        while(true) {
            N = Integer.parseInt(br.readLine());

            if(N ==0)
                break;

            arr = new int[N+1][N+1];
            rupee = new int[N+1][N+1];

            for(int i =1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j =1; j<=N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    rupee[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs(1,1);

            sb.append("Problem ").append(problemIndex++).append(": ");
            sb.append(rupee[N][N]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int x, int y) {

        Queue<int []> queue = new LinkedList<>();

        queue.add (new int[] { x,y});
        rupee[x][y] = arr[x][y];
        

        while(!queue.isEmpty()) {

            int now[] = queue.poll();

            int nowx = now[0];
            int nowy = now[1];

            for(int i = 0; i<4; i++) {
                int nx = nowx + dx[i];
                int ny = nowy + dy[i];

                if(nx >=1 && ny >=1 && nx <=N && ny <=N) {
                    if(rupee[nx][ny] > rupee[nowx][nowy] + arr[nx][ny]) {
                        rupee[nx][ny] = rupee[nowx][nowy] + arr[nx][ny];
                        queue.add(new int[] { nx,ny});
                    }

                }
            }
        }
    }
}
