import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

public class Main {

        static boolean []visited;
        static ArrayList<Integer>[]A;
        static int n,m;
        static int answer =0;
        
        public static void main(String[] args) throws IOException 
        {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                n = Integer.parseInt(br.readLine());

                m = Integer.parseInt(br.readLine());

                A = new ArrayList[n+1];
                
                visited = new boolean[n+1];

                for(int i =0; i<=n; i++)
                {
                        A[i]= new ArrayList<Integer>();
                }

                StringTokenizer st;
                for(int i =0; i<m; i++)
                {
                        st = new StringTokenizer(br.readLine());
                        int s = Integer.parseInt(st.nextToken());
                        int e = Integer.parseInt(st.nextToken());

                        A[s].add(e);
                        A[e].add(s);
                }
                BFS(1);

                System.out.println(answer);


        }

        private static void BFS(int Node)
        {
                Queue<Integer> queue = new LinkedList<Integer>();

                queue.add(Node);

                visited[Node]= true;


                while(!queue.isEmpty())
                {
                        int now_node = queue.poll();

                        visited[now_node]=true;


                        for(int temp: A[now_node])
                        {
                                if(visited[temp]==false)
                                {
                                        queue.add(temp);
                                        visited[temp]=true;
                                        answer++;
                                }
                        }
                }
        }

}
