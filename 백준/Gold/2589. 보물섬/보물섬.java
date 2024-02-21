import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

public class Main {
        static int[] dx = {-1,1,0,0};
        static int[] dy = {0,0,-1,1};
        static char[][] arr;
        static int visited[][];
        static int cnt, N,M,max;

        public static void main(String[] args) throws IOException 
        {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                StringTokenizer st = new StringTokenizer(br.readLine());

                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                arr = new char[N][M];

                for(int i =0; i<N; i++)
                {
                        String str = br.readLine();
                        for(int j =0; j<M; j++)
                        {
                                arr[i][j]=str.charAt(j);
                        }
                }

                cnt = 0;
                max= 0;
                visited =new int[N][M];
                for(int i =0; i<N; i++)
                {
                        for(int j =0; j<M; j++)
                        {
                                if(arr[i][j]=='L' && visited[i][j]==0)
                                {
                                        BFS(i,j);
                                        visited =new int[N][M];
                                } 
                        }
                }

                System.out.println(max-1);
        }


        private static void BFS(int i, int j)
        {
                Queue<int[]> queue = new LinkedList<>();

                queue.add(new int[] {i,j});
                visited[i][j]++;

                while(!queue.isEmpty())
                {
                        int curX = queue.peek()[0];
                        int curY = queue.peek()[1];
                        queue.poll();

                        for(int k =0; k<4; k++)
                        {
                                int nx= curX +dx[k];
                                int ny = curY+dy[k];

                                if(nx>=0 && ny>=0 && nx<N && ny<M)
                                {
                                        if(arr[nx][ny]=='L' && visited[nx][ny]==0)
                                        {
                                                queue.add(new int[]{nx,ny});
                                                visited[nx][ny]=visited[curX][curY]+1;
                                                if(max<visited[nx][ny])
                                                        max=visited[nx][ny];
                                        }
                                }
                        }
                }
                



        }


}
