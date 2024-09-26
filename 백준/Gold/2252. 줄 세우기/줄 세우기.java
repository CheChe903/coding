import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> A[];
    static boolean[] visited;
    static int N,M;
    static int[] count;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A= new ArrayList[N+1];
        count = new int[N+1];
        for(int i =1; i<=N; i++){
            A[i] = new ArrayList<>();
        }

        visited= new boolean[N+1];

        for(int i =0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
            count[E]++;
        }

        sb= new StringBuilder();
        bfs();

        System.out.println(sb);
    }

    static void bfs() {

        Queue<Integer> queue = new LinkedList<>();

        for(int i =1; i<=N; i++) {
            if(count[i]==0)
                queue.add(i);
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");

            for(int next: A[cur]) {
                count[next]--;
                if(count[next]==0) {
                    queue.add(next);
                }
            }

        }

    }
}

