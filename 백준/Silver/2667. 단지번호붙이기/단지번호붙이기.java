import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

public class Main {

        static int dx[] = {0,0,1,-1};
        static int dy[] = {1,-1,0,0};
        static boolean [][]visited;
        static int [][]A;
        static int n,cnt;
        static int answer =0;
        static List<Integer> result;
        public static void main(String[] args) throws IOException 
        {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                n = Integer.parseInt(br.readLine());
                
                visited = new boolean[n][n];

                result =new LinkedList<>();

                A = new int[n][n];

                for(int i =0; i<n; i++)
                {
                        String str = br.readLine();
                        for(int j =0; j<n; j++)
                        {
                                A[i][j]= str.charAt(j)-'0';
                        }
                }

                cnt =1;
                for(int i =0; i<n; i++)
                {
                        for(int j =0; j<n; j++)
                        {
                                if(visited[i][j]==false && A[i][j]==1)
                                {
                                        visited[i][j]=true;
                                        BFS(i,j);
                                        result.add(cnt);
                                        cnt=1;
                                }
                        }
                }

                Collections.sort(result);
                StringBuilder sb =new StringBuilder();
                sb.append(result.size()).append("\n");

                for(int i =0; i<result.size(); i++)
                {
                        sb.append(result.get(i)).append("\n");
                }

                System.out.println(sb);
        }
        public static void BFS(int i, int j)
        {
                Queue<int[]> queue= new LinkedList<>();
                queue.add(new int[]{i,j});

                while(!queue.isEmpty())
                {
                        int curX = queue.peek()[0];
                        int curY = queue.peek()[1];
                        queue.poll();


                        for(int k =0; k<4; k++)
                        {
                                int nx = curX +dx[k];
                                int ny = curY+ dy[k];


                                if(nx >=0 && ny>=0 && nx<n && ny<n)
                                {
                                        if(A[nx][ny]==1 && visited[nx][ny]==false)
                                        {
                                                queue.add(new int[]{nx,ny});
                                                visited[nx][ny]=true;
                                                cnt++;
                                        }
                                }
                        }
                }

        }



}
