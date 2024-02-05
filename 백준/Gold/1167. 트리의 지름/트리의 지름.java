import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
        static boolean[] visited;
        static int[] distance;
        static ArrayList<Edge>[] A;
        
	public static void main(String[] args) throws IOException 
        {       
                BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

                int N = Integer.parseInt(br.readLine());

                A= new ArrayList[N+1];

                for(int i =1; i<=N; i++)
                {
                        A[i]= new ArrayList<Edge>();
                }

                StringTokenizer st;
                for (int i =0; i<N; i++)
                {
                        st= new StringTokenizer(br.readLine());
                        int S = Integer.parseInt(st.nextToken());

                        while(true)
                        {
                                int E =  Integer.parseInt(st.nextToken());
                                if ( E ==-1)
                                        break;
                                int V = Integer.parseInt(st.nextToken());
                                A[S].add(new Edge(E,V));
                        }
                }

                distance = new int[N+1];
                visited = new boolean[N+1];
                BFS(1);
                int max =1;

                for(int i=2; i<=N; i++)
                {
                        if(distance[max] < distance[i])
                                max = i;
                }
                distance = new int[N+1];
                visited = new boolean[N+1];
                BFS(max);

                Arrays.sort(distance);
                StringBuilder sb = new StringBuilder();

                sb.append(distance[N]);

                System.out.println(sb);
        }

        private static void BFS(int index)
        {
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.add(index);
                visited[index]=true;
                while(!queue.isEmpty())
                {
                        int now_node = queue.poll();

                        for(Edge i : A[now_node])
                        {
                                int e =i.e;
                                int v = i.value;
                                if(!visited[e])
                                {
                                        visited[e]= true;
                                        queue.add(e);
                                        distance[e] = distance[now_node]+v;
                                }
                        }
                }
        }




}

class Edge 
{
        int e;
        int value;
        public Edge(int e, int value)
        {
                this.e = e;
                this.value = value;
        }
}

