import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
        static ArrayList<Integer>[] A;
        static boolean[] visited;

	public static void main(String[] args) throws IOException 

        {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
                StringTokenizer st = new StringTokenizer(br.readLine());

                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());


                A = new ArrayList[n+1];
                visited = new boolean[n+1];
                for(int i =1; i<=n; i++)
                {
                        A[i]= new ArrayList<Integer>();
                }

                for(int i =0; i<m; i++)
                {
                        st = new StringTokenizer(br.readLine());
                        int s = Integer.parseInt((st.nextToken()));
                        int e = Integer.parseInt((st.nextToken()));

                        A[s].add(e);
                        A[e].add(s);
                }

                for(int i =1; i<=n; i++)
                {
                        Collections.sort(A[i]);
                }

                DFS(start);

                System.out.println();
                visited = new boolean[n+1];

                BFS(start);
                System.out.println();

        }


        public static void DFS(int v)
        {
                System.out.print(v + " ");
                visited[v] =true;
                for(int i :A[v])
                {
                        if(!visited[i])
                                DFS(i);
                }                
        }

        private static void BFS(int v)
        {
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.add(v);
                visited[v]= true;
                while(!queue.isEmpty())
                {
                        int now = queue.poll();

                        System.out.print(now +" ");
                        for(int i : A[now])
                        {
                                if(!visited[i])
                                {
                                        visited[i]= true;
                                        queue.add(i);
                                }
                        }
                }
        }


}

