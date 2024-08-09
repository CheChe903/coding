import java.io.*;
import java.util.*;

public class Main {

    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] city;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N= Integer.parseInt(br.readLine());

        city = new int[N][N];

        visited = new boolean[N][N];
        StringTokenizer st;
        for(int i =0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++)
            {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max =1;

        for(int i =1; i<=100; i++)
        {
            visited = new boolean[N][N];

            int answer = 0;
            for(int j = 0; j<N; j++)
            {
                for(int k = 0; k<N; k++)
                {
                    if(visited[j][k]== false && city[j][k] > i )
                    {
                        bfs(j,k,i);
                        answer++;
                }
            }
            if(max < answer)
                max = answer;
            }

        }
        System.out.println(max);

    }

    public static void bfs(int x, int y, int width)
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

                if(curx>=0 && curx <N && cury>=0 && cury<N &&
                    visited[curx][cury] == false && city[curx][cury]>width)
                {
                    queue.add (new int[] { curx, cury});
                    visited[curx][cury]= true;

                }
            }
        }
    }
}
