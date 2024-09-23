import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer> A[];
    static boolean[] visited;
    static int N,M;
    static int answer;
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        N = Integer.parseInt(br.readLine());

        M = Integer.parseInt(br.readLine());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];


        for(int i =1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }

        StringTokenizer st;

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
            A[E].add(S);
        }   

        answer = 0;

        bfs(1);

        System.out.println(answer);
    }

    static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        int dep = 0;

        visited[start] = true;

        for(int cur : A[1]) {
            if(visited[cur]== false) {
                answer++;
                visited[cur]= true;
                queue.add(cur);
            }

        }

        while(!queue.isEmpty()) {

            int now = queue.poll();

            for(int cur : A[now]) {
                if(visited[cur] == false){
                    answer++;
                    visited[cur] = true;
                }
            }
        }
    }


}

