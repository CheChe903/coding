import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i =1; i<=N; i++) {
            A[i] = new ArrayList<>();

            String input = br.readLine();

            for(int j = 0; j<N; j++) {
                if(input.charAt(j)== 'Y') {
                    A[i].add(j+1);
                }
            }
        }

        int answer = -1;

        for(int i=1; i<=N;i++) {
            visited = new boolean[N+1];
            int count = bfs(i);
            
            answer = Math.max(answer,count);
        }
        System.out.println(answer);
    }

    static int bfs(int now) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(now);
        visited[now] =true;

        int count = 0;
        for(int cur : A[now]) {
            count +=1;
            visited[cur]= true;
            queue.add(cur);
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int cur2 : A[cur]) {
                if(visited[cur2]== false) {
                    count++;
                    visited[cur2]= true;
                }
            }
        }

        return count;
    }
}
