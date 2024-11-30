import java.io.*;
import java.util.*;

public class Main {
    static char arr[][];
    static int N,M,answer=0;
    static boolean visited[][];
    static int dx[]  ={ -1,1,0,0};
    static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        arr = new char[N+1][M+1];
        int doX = 0;
        int doY = 0;

        for(int i =1; i<=N; i++) {
            String input = br.readLine();
            for(int j =1; j<=M; j++) {
                arr[i][j] = input.charAt(j-1);

                if(arr[i][j] == 'I') {
                    doX=i;
                    doY = j;
                }
            }
        }
        visited = new boolean[N+1][M+1];
        bfs(doX,doY);
        if(answer ==0)
            System.out.println("TT");
        else
            System.out.println(answer);
    }

    static void bfs(int startX, int startY)  {

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] { startX, startY});
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            int nowx = now[0];
            int nowy = now[1];
            if(arr[nowx][nowy] == 'P') {
                answer++;
            }

            for(int i = 0; i<4; i++) {
                int nx = nowx+ dx[i];
                int ny = nowy + dy[i];

                if(nx >=1 && nx <=N && ny >=1 && ny <=M) {
                    if(visited[nx][ny] == false && arr[nx][ny] != 'X') {
                        queue.add(new int[] {nx,ny});
                        visited[nx][ny]= true;
                    }
                }
            }
        }
    }
}  