import java.io.*;
import java.util.*;

public class Main {

    static int arr[][];
    static boolean[] visited;
    static int N;  
    static int answer;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i =1; i<=N; i++) {
            st=  new StringTokenizer(br.readLine());
            for(int j =1; j<=N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = Integer.MAX_VALUE;

        dfs(1,0);
        System.out.println(answer);
    }
    static void dfs(int idx, int count) {
        if(count *2 == N) {
            countStat();
        }

        for(int i = idx; i<=N; i++) {
            if(!visited[i]) {
                visited[i]= true;
                dfs(i+1, count+1);
                visited[i]=false;
            }
        }
    }

    static void countStat() {
        int teamStart =0;
        int teamLink=0;


        for(int i =1; i<N; i++) {
            for(int j = i+1; j<=N; j++) {
                if(visited[i]==true && visited[j]==true) {
                    teamStart = arr[i][j] + arr[j][i] + teamStart;
                }
                else if(visited[i]==false && visited[j]==false) {
                    teamLink = teamLink+ arr[i][j] +arr[j][i];
                }
            }
        }

        if(Math.abs(teamLink- teamStart) ==0) {
            System.out.println(0);
            System.exit(0);
        }

        answer =Math.min(answer, Math.abs(teamLink-teamStart));
    }

}
