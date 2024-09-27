import java.io.*;
import java.util.*;

public class Main {

    static class Pair implements Comparable<Pair> {

        int end;
        int value;

        Pair(int end, int value) {
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Pair other) {

            return this.value - other.value;
        }
    }

    static ArrayList<Pair> A[];
    static int dist[];
    public static void main(String[] args) throws IOException {

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        A = new ArrayList[N+1];
        dist = new int[N+1];
        for(int i =1; i<=N;i++) {
            A[i] = new ArrayList<>();
        
        }   

        for(int i =1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            A[S].add(new Pair(E, V));
        }

        for(int i =1; i<=N; i++) {
            
            dist = new int[N+1];
            for(int j=1; j<=N; j++) {
                dist[j] = Integer.MAX_VALUE;
            }
            bfs(i);

            for(int j =1; j<=N; j++) {
                if(dist[j] != Integer.MAX_VALUE)
                    System.out.print(dist[j]+" ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }

    static void bfs(int start) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(start, 0));

        dist[start]= 0;

        while(!pq.isEmpty()) {

            Pair cur = pq.poll();

            int now = cur.end;
            int nowCost = cur.value;

            if(dist[now] <nowCost ) continue;

            for(Pair next: A[now]) {
                int cost = nowCost+ next.value;

                if(cost < dist[next.end]) {
                    dist[next.end] = cost;
                    pq.add(new Pair(next.end, cost));
                }
            }
        }

    }
}

