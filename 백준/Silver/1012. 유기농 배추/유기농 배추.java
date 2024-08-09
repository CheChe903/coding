import java.io.*;
import java.util.*;

public class Main {

    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] baechu;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for(int i =0; i<T; i++)
        {
            int answer =0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            baechu = new int[N][M];

            visited = new boolean[N][M];

            for(int j =0; j<K; j++)
            {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                baechu[x][y]=1;
            }

            for(int z = 0; z<N; z++)
            {
                for(int c = 0; c<M; c++)
                {
                    if(baechu[z][c] == 1 && visited[z][c] == false)
                    {
                        bfs(z,c);
                        answer++;
                    }                
                }
            }
            sb.append(answer+"\n");

        }

        System.out.println(sb);

    }

    public static void bfs(int x, int y)
    {
        visited[x][y]= true;

        Queue<int []> queue = new LinkedList<>();

        queue.add(new int [] {x,y});


        while(!queue.isEmpty())
        {
            int []cur = queue.poll();

            int cx = cur[0];
            int cy = cur[1];
            for(int i =0; i<4; i++)
            {
                int curx = cx + dx[i];
                int cury = cy + dy[i];

                if(curx>=0 && curx <N && cury>=0 && cury<M &&
                    visited[curx][cury] == false && baechu[curx][cury] == 1)
                {
                    queue.add (new int[] { curx, cury});
                    visited[curx][cury]= true;

                }
            }
        }
    }
}
