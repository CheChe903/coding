import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> A[];
    static boolean visited[];
    static int parent[];
    static int N,answer;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        parent = new int[N+1];

        for(int i =1; i<=N; i++) {
            A[i] = new ArrayList<>();
            parent[i]= -1;
        }   

        StringTokenizer st;
        for(int i =0;i<N-1; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A[S].add(E);
            A[E].add(S);
        }   

        bfs(1);

        for(int i =2; i<=N; i++) {
            System.out.println(parent[i]);
        }
    }

    static void bfs(int start) {

        visited[start] = true;
        parent[start]= 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {

            int now = queue.poll();
            for(int cur : A[now]) {
                if(visited[cur] == false && parent[cur]== -1) {
                    visited[cur] = true;
                    parent[cur] = now;
                    queue.add(cur);
                }
            }
        }


    }



}

