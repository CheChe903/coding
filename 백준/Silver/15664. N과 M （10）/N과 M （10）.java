import java.io.*;
import java.util.*;

public class Main {
    static int N, M, arr[];
    static boolean visited[];
    static StringBuilder sb;
    static Set<String> set;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1];
        visited = new boolean[N+1];
        sb = new StringBuilder();
        set = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 수열을 오름차순으로 정렬
        Arrays.sort(arr);
        
        dfs(1, 1, "");
        System.out.print(sb.toString());
    }
    
    static void dfs(int start, int depth, String current) {
        if(depth == M + 1) {
            if(!set.contains(current)) {
                set.add(current);
                sb.append(current.trim()).append("\n");
            }
            return;
        }
        
        for(int i = start; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1, current + arr[i] + " ");
                visited[i] = false;
            }
        }
    }
}