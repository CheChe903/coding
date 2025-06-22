import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M, arr[][];
    static int[][][] dist;
    static int dx[] = { -1,1, 0,0};
    static int dy[] = { 0,0,-1,1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr =  new int[N][M];
        dist = new int[2][N][M];

        for(int i =0; i<N; i++) {
            String input = br.readLine();
            for(int j =0; j <M; j++) {  
                arr[i][j] = Integer.parseInt(input.charAt(j)+"");
            }
        }

        bfs();
        
        int notBrokenAnswer = dist[0][N-1][M-1];
        int brokenAnswer = dist[1][N-1][M-1];

        if(notBrokenAnswer != 0 && brokenAnswer != 0) {
            if(notBrokenAnswer >= brokenAnswer) {
                System.out.println(brokenAnswer);
            }
            else {
                System.out.println(notBrokenAnswer);
            }
        }
        else if(notBrokenAnswer !=0) {
            System.out.println(notBrokenAnswer);
        }
        else if (brokenAnswer != 0) {
            System.out.println(brokenAnswer);
        }
        else {
            System.out.println(-1);
        }
    }

    static void bfs() {

        Queue<int []> queue = new LinkedList<>();

        dist[0][0][0] = 1;
        queue.add(new int[] {0,0,0});

        while(!queue.isEmpty()) {
            int now[] = queue.poll();

            int nowx = now[0];
            int nowy = now[1];
            int broken = now[2];

            int nowValue = dist[broken][nowx][nowy];
            for(int i =0; i<4; i++) {
                int nx = nowx + dx[i];
                int ny = nowy + dy[i];

                if(nx >=0 && nx<N && ny>=0 && ny <M) {

                    if(arr[nx][ny] == 0 && dist[broken][nx][ny] == 0) {
                        dist[broken][nx][ny] = nowValue+1;
                        queue.add(new int[]{ nx, ny, broken});
                    }
                    else if(arr[nx][ny] == 1 && broken==0 && dist[1][nx][ny] == 0) {
                        dist[1][nx][ny] = nowValue+1;
                        queue.add(new int[]{nx,ny,1});
                    }
                }
            }
        }

    }
}
