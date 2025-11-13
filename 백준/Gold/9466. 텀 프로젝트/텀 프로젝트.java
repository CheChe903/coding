import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean []visited;
    static boolean []done;
    static int cnt;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int test=0; test<T; test++) {
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int arr[] = new int [N+1];
            
            for(int i =1; i<=N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            cnt = 0;
            visited = new boolean[N+1];
            done = new boolean[N+1];
            for(int i =1;i <=N; i++) {
                if(!visited[i]) {
                    dfs(i,arr);
                }
            }
            sb.append(N - cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int now, int arr[]) {
        visited[now] = true;
        int next = arr[now];

        if(!visited[next]) {
            dfs(next,arr);
        } else if(!done[next]) {
            cnt++;
            for(int i =next; i != now; i= arr[i]) cnt ++;
        }
        done[now] = true;
    }

}

//dfs인데, 자기 자신으로 돌아오면 ㅇㅋ 인가?
//1 ->2 -> 5 -> 2
//배열을 새로 생성하지 않고도 확인하는 법이 있을까 .. ?