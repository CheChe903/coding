import java.io.*;
import java.util.*;


public class Main {
    static boolean visited[][];
    static int arr[][];
    static int N,M,answer;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];
        int countAnswer = 0;
        answer = 0;
        for(int i =0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                if(arr[i][j] == 1 && visited[i][j] == false) {
                    countAnswer++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(countAnswer);
        System.out.println(answer);
    
    }

    static void bfs(int x, int y) {

        Queue<int[] > queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y] = true;
        int count =1;

        while(!queue.isEmpty()) {
            
            int now[] = queue.poll();
            int nowx = now[0];
            int nowy = now[1];
            for(int i =0; i<4; i++) {
                int nx = nowx + dx[i];
                int ny = nowy + dy[i];

                if(nx >=0 && nx<N && ny >=0 && ny <M) {
                    if(visited[nx][ny]==false && arr[nx][ny]== 1) {
                        count++;
                        queue.add(new int[] { nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }


        answer = Math.max(answer,count);
    }
}

