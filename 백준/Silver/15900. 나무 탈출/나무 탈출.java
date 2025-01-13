import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> A[];
    static int ans;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i =1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }
        for(int i =0; i<N-1; i++) {
            st  = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A[S].add(E);
            A[E].add(S);
        }
        ans =0;

        dfs(1,0);

        if(ans %2 ==0)
            System.out.println("No");
        else
            System.out.println("Yes");
    }

    static void dfs(int node, int cnt) {

        visited[node] = true;

        for(int next : A[node]) {
            if(visited[next]== false) {
                dfs(next,cnt+1);
            }
        }

        if(node !=1 && A[node].size()==1) {
            ans +=cnt;
        }
    }
}