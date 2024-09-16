import java.io.*;
import java.util.*;
public class Main{
    
    static char arr[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int N;
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr= new char[N][N];
        
        for(int i= 0; i<N; i++) {
            String input = br.readLine();    
    

            for(int j =0; j<N; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        visited= new boolean[N][N];
        int count =0;
        for(int i =0; i< N; i++) {
            for(int j =0; j<N; j++) {

                if(visited[i][j] == false) {
                    bfs(i,j);
                    count++;
                }

                if(arr[i][j] == 'G')
                    arr[i][j] ='R';
            }
        }
        System.out.print(count +" ");
        count =0;
        visited= new boolean[N][N];

        for(int i =0; i< N; i++) {
            for(int j =0; j<N; j++) {

                if(visited[i][j] == false) {
                    bfs(i,j);
                    count++;
                }
            }
        }

        System.out.print(count);

    }  

    static void bfs(int x, int y) {

        Queue<int []> queue = new LinkedList<>();

        queue.add(new int[] { x,y});

        visited[x][y] = true;


        while(!queue.isEmpty()) {
            int [] now = queue.poll();

            int nowx = now[0];
            int nowy = now[1];

            for(int i =0; i<4; i++) {
                int nx = nowx + dx[i];
                int ny = nowy + dy[i];

                if(nx >=0 && ny >=0 && nx <N && ny <N && !visited[nx][ny]) {

                    if(arr[nowx][nowy] == arr[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx,ny});
                    }
                }
            }
        }
    }
}