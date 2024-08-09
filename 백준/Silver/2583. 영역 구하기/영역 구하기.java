import java.io.*;
import java.util.*;

public class Main {

    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] city;
    static int M,N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        city = new int[M][N];
        visited = new boolean[M][N];

        for(int i =0; i<K; i++)
        {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) 
            { 
                for (int x = x1; x < x2; x++) 
                {
                    city[y][x] = 1; 
                }
            }
        }

        int answer =0;
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i =0; i<M; i++)
        {
            int count = 0;
            for(int j =0; j<N; j++)
            {
                if(city[i][j]==0 && visited[i][j]== false)
                {
                    count =0;
                    count = bfs(i,j);
                    answer++;
                    queue.add(count);

                }
            }
        }

        sb.append(answer+"\n");
        while(!queue.isEmpty())
        {
            sb.append(queue.poll()+" ");
        }

        System.out.println(sb);
    }

    public static int bfs(int x, int y)
    {
        visited[x][y]= true;

        Queue<int []> queue = new LinkedList<>();

        queue.add(new int [] {x,y});

        int count =1;

        while(!queue.isEmpty())
        {
            int []cur = queue.poll();

            int cx = cur[0];
            int cy = cur[1];
            for(int i =0; i<4; i++)
            {
                int curx = cx + dx[i];
                int cury = cy + dy[i];

                if(curx>=0 && curx <M && cury>=0 && cury<N &&
                    visited[curx][cury] == false && city[curx][cury]==0)
                {
                    queue.add (new int[] { curx, cury});
                    visited[curx][cury]= true;
                    count++;
                }
            }
        }

        return count;
    }
}
