import java.io.*;
import java.util.*;

public class Main {
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static boolean[][] visited;
    static int arr[][];
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        int answer = 0;

        for(int i =0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            arr[X][Y] = 1;
        }

        for(int i =1; i<=N; i++) {
            for(int j =1; j<=M; j++) {
                if(arr[i][j] ==1 && visited[i][j]== false) {
                    int curAnswer = bfs(i,j);
                    answer = Math.max(answer, curAnswer);
                }
            }
        }

        System.out.println(answer);

    }
    static int bfs(int x, int y) {
        
        Queue<int[]> queue = new LinkedList<>();
        int count = 1;
        queue.add(new int[] { x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            int nowx= now[0];
            int nowy = now[1];

            for(int i =0; i<4; i++) {
                int nx = nowx + dx[i];
                int ny = nowy + dy[i];

                if(nx >=1 && nx<=N && ny >=1 && ny <=M) {
                    if(arr[nx][ny] == 1 && visited[nx][ny] == false) {
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}