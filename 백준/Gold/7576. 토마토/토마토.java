import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

public class Main {

        static int[][] visited;
        static int[] dx = {-1,1,0,0};
        static int[] dy = {0,0,-1,1};
        static int n,m;
        static int[][] arr;

        public static void main(String[] args) throws IOException 
        {

                BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());

                m = Integer.parseInt(st.nextToken());
                n = Integer.parseInt(st.nextToken());

                arr = new int[n][m];
                boolean good =true;
                for(int i =0; i<n; i++)
                {
                        st = new StringTokenizer(br.readLine());
                        for(int j =0; j<m; j++)
                        {
                                arr[i][j]=Integer.parseInt(st.nextToken());
                                if(arr[i][j]==0 || arr[i][j]==-1)
                                        good= false;

                        }
                }

                if(good)
                {
                        System.out.println(0);
                        return;
                }
                else
                {

                        BFS();

                        int max= -1;
                        for(int i =0; i<n; i++)
                        {
                                for(int j =0; j<m; j++)
                                {
                                        if(arr[i][j]==0)
                                        {
                                                System.out.println(-1);
                                                return;
                                        }
                                        else if(max<arr[i][j])
                                                max=arr[i][j];
                                }
                        }
                        System.out.println(max-1);
                }
        }
        public static void BFS()
        {
                Queue<int[]> queue = new LinkedList<>();

                for(int t = 0; t<n; t ++)
                {
                        for(int r = 0; r<m; r++)
                        {
                                if(arr[t][r]==1)
                                        queue.add(new int[]{t,r});
                        }
                }
                while(!queue.isEmpty())
                {
                        int curX = queue.peek()[0];
                        int curY = queue.peek()[1];
                        
                        queue.poll();

                        for(int k =0; k<4; k++)
                        {
                                int nx = curX + dx[k];
                                int ny = curY + dy[k];

                                if(nx >=0 && ny>=0 && nx<n && ny<m)
                                {
                                        if(arr[nx][ny]==0)
                                        {
                                                queue.add(new int[]{nx,ny});
                                                arr[nx][ny]= arr[curX][curY]+1;
                                        }

                                }
                        }
                }
        }
}
