import java.io.*;
import java.util.*;

public class Main {

    static int H,W;
    static char arr[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i =0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            arr = new char[H][W];
            visited = new boolean[H][W];
            for(int j = 0; j<H; j++) {
                String input =  br.readLine();
                for(int k =0; k<W; k++) {
                    arr[j][k] = input.charAt(k);
                }    
            }
            int count =0;
            for(int j = 0; j<H; j++) {
                for(int k =0; k<W; k++) {
                    if(visited[j][k] == false && arr[j][k] == '#') {
                        bfs(j,k);
                        count+=1;
                    }
                }    
            }

            sb.append(count).append("\n");

        }

        System.out.println(sb);
    }

    static void bfs(int startX, int startY) {

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] { startX, startY});

        visited[startX][startY] =true;


        while(!queue.isEmpty()) {

            int now[] = queue.poll();
            int nowx = now[0];
            int nowy = now[1];

            for(int i =0; i<4; i++) {

                int nx = nowx + dx[i];
                int ny = nowy + dy[i];

                if(nx >=0 && nx<H && ny>=0 && ny < W) {
                    if(visited[nx][ny]== false && arr[nx][ny] =='#') {
                        queue.add(new int[] { nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
 
    }
}