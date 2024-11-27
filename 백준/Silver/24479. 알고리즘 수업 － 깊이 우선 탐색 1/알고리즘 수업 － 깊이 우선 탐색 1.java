import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static int[] visited;
    static StringBuilder sb = new StringBuilder();
    static int currentDepth = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        visited = new int[N+1];

        for(int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        // 간선 입력받기 
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
            A[E].add(S);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        visited[R] = currentDepth++;
        dfs(R);

        for(int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int start) {
        for(int next : A[start]) {
            if(visited[next] == 0) {
                visited[next] = currentDepth++;
                dfs(next);
            }
        }
    }
}