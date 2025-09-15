import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<int []> list[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for(int i =1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1;i <N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[start].add(new int[]{end, value});
            list[end].add(new int[]{start, value});
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0;i <M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[N + 1];
            int dist = dfs(start, end, 0, visited);
            sb.append(dist).append("\n");
        }
        System.out.println(sb);
    }

    static int dfs(int start, int end, int value, boolean[] visited) {
        if(start == end) {
            return value;
        }
        visited[start] = true;

        for(int cur[] : list[start]) {
            if(visited[cur[0]]) continue;
            int result = dfs(cur[0], end, value+ cur[1], visited);
            if(result != -1) return result;
        }
        return -1;
    }
}
