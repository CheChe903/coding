import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int dist[][] = new int[N+1][N+1];
        final int INF = 1_000_000;
        for(int i =1; i<=N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start =Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(start == -1 && end == -1) {
                break;
            }
            dist[start][end] = 1;
            dist[end][start] = 1; 
        }

        for(int k = 1; k<=N; k++) {
            for(int i =1; i<=N; i++) {
                for(int j = 1; j<=N; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int score[] = new int[N+1];

        int best = INF;

        for(int i =1;i <=N; i++) {
            int cur = 0;
            for(int j =1; j<=N; j++) {
                cur = Math.max(cur, dist[i][j]);
            }
            score[i] = cur;
            best = Math.min(cur, best);
        }

        List<Integer> list = new ArrayList<>();

        for(int i =1; i<=N; i++) {
            if(score[i] == best) {
                list.add(i);
            }
        }

        System.out.println(best +" " + list.size());
        for(int i = 0; i <list.size(); i++) {
            System.out.print(list.get(i));
            if (i  != list.size()-1) {
                System.out.print(" ");
            }   
        }
    }
}
