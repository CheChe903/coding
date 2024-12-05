import java.io.*;
import java.util.*;

public class Main {
    static int r1,c1,r2,c2,N;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static int answer = 0;
    static int visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        N = Integer.parseInt(br.readLine());

        visited = new int[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++) {
            for(int j =0; j<N; j++) {
                visited[i][j] = -1;
            }
        }
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        bfs(r1,c1);
        if(visited[r2][c2] == 0 ){ 
            System.out.println(-1);
        }
        else
            System.out.println(visited[r2][c2]);
    }

    static void bfs(int x, int y) {

        Queue<int[] > queue = new LinkedList<>();

        queue.add(new int[] {x,y});
        visited[x][y] =0;

        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            int nowx = now[0];
            int nowy = now[1];

            if(nowx == r2 && nowy == c2) {
                break;
            }

            for(int i =0; i<6; i++) {
                int nx = nowx + dx[i];
                int ny = nowy + dy[i];

                if(nx >=0 && nx  <N && ny >=0 && ny <N) {
                    if(visited[nx][ny] == -1 || visited[nx][ny] > visited[nowx][nowy]+1) {
                        queue.add(new int[] {nx,ny});
                        visited[nx][ny] = visited[nowx][nowy]+1;
                    }
                }

            }
        }
    }
}