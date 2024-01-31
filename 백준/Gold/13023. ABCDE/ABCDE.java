import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


import java.io.IOException;
import java.util.*;
public class Main {
        static int N,M;
        static StringBuilder sb =new StringBuilder();
        static boolean[] visited;
        static ArrayList<Integer>[] A;
        static boolean arrive;

	public static void main(String[] args) throws IOException 
        {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());

                A = new ArrayList[N];
                visited = new boolean[N];


                for(int i =0; i<N; i++)
                {
                        A[i] = new ArrayList<Integer>();
                }
                for(int i =0; i<M; i++)
                {
                        st = new StringTokenizer(br.readLine());
                        int s = Integer.parseInt(st.nextToken());
                        int e = Integer.parseInt(st.nextToken());

                        A[s].add(e);
                        A[e].add(s);
                }

                for(int i =0; i<N; i++)
                {

                        DFS(i,1);
                        if(arrive)
                                break;
                }
                if(arrive)
                        sb.append("1");

                else
                {
                        sb.append("0");
                }

                System.out.println(sb);
        }

        static void DFS(int v,int depth)
        {

                if(depth ==5 || arrive)
                {
                        arrive = true;
                        return;
                }
                visited[v] = true;
                
                for(int i : A[v])
                {
                        if(!visited[i])
                        {
                                DFS(i,depth+1);
                        }
                }
                visited[v]= false;
        }



}

