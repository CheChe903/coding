import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int arr[][];
    static boolean visited[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());
        arr= new int[N][M];
        visited = new boolean[N][M];
        
        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            for(int j = 0; j< M*3; j+=3) {
                int cnt = 0;
                for(int k = j; k < j+3; k++) {
                    cnt += Integer.parseInt(st.nextToken());
                }
                arr[i][idx++] = cnt/3;
            }
        }
        int boundary = Integer.parseInt(br.readLine());

        for(int i =0; i <N; i++) {
            for(int j =0; j<M; j++) {
                if(arr[i][j] <boundary) {
                    arr[i][j] = 0;
                }
                else {
                    arr[i][j] = 255;
                }
            }
        }
        int answer = 0;
        for(int i =0; i <N; i++) {
            for(int j =0; j<M; j++) {
                if(visited[i][j] == false && arr[i][j] == 255) {
                    bfs(i,j);
                    answer +=1;
                }
            }
        }
        System.out.println(answer);
    }

    static void bfs(int startX, int startY) {

        Queue<int []> queue = new LinkedList<>();

        queue.add(new int[] {startX, startY});
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int now[] = queue.poll();

            int nowx = now[0];
            int nowy = now[1];

            for(int i = 0; i <4; i++) {
                int nx = dx[i] + nowx;
                int ny = dy[i] + nowy;

                if(nx >=0 && ny >=0 && nx<N && ny <M) {
                    if(arr[nx][ny] == 255 && visited[nx][ny]== false) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{ nx,ny});
                    }
                }
            }


        }
    }
    
}