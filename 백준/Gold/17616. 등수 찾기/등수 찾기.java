import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] A;
    static ArrayList<Integer>[] B;
    static int count;
    static int myn;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n,m,k;

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        myn =n;
    
        A = new ArrayList[n+1];
        B = new ArrayList[n+1];

        for(int i =1; i<=n; i++)
        {
            A[i] = new ArrayList<>();
            B[i] = new ArrayList<>();
        }

        for(int i =0; i<m; i++)
        {
            int a,b;
            st = new StringTokenizer(br.readLine());
            a= Integer.parseInt(st.nextToken());
            b= Integer.parseInt(st.nextToken());
            A[a].add(b);
            B[b].add(a);
        }

        count = 0;
        bfs(k, B);
        System.out.print(count+" ");

        count =0;

        bfs(k, A);
        System.out.print((n-count+1));

    }

    public static void bfs(int x, List<Integer>[] my)
    {
        boolean visited[] = new boolean[myn+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        visited[x]= true;

        while(!queue.isEmpty())
        {
            count++;
            int now = queue.poll();

            for(int nownode: my[now])
            {
                if(visited[nownode]==false)
                {
                    queue.add(nownode);
                    visited[nownode] = true;
                    
                }
            }
        }

    }
}
