import java.io.*;
import java.util.*;

public class Main {

    static class Pair implements Comparable<Pair> {
        int end;
        int value;

        Pair(int end, int value) {
            this.end =end;
            this.value = value;
        }
        @Override
        public int compareTo(Pair other) {
            return this.value - other.value;
        }
    }

    static ArrayList<Pair> A[];
    static int arr[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        A = new ArrayList[N+1];

        arr= new int[N+1];

        for(int i =1; i<=N; i++) {
            A[i] = new ArrayList<>();

            arr[i] = Integer.MAX_VALUE;
        }

        for(int i =0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            A[S].add(new Pair(E, V));
        }
        st = new StringTokenizer(br.readLine());
        int startPos = Integer.parseInt(st.nextToken());
        int endPos = Integer.parseInt(st.nextToken());

        bfs(startPos);

        System.out.println(arr[endPos]);
    }
    
    static void bfs(int start) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        arr[start] = 0;

        pq.offer(new Pair(start, 0));
        while(!pq.isEmpty()) {

            Pair cur = pq.poll();

            
            int now = cur.end;
            int nowCost = cur.value;

            if (arr[now] < nowCost) continue;

            for(Pair next : A[now]) {

                int cost = nowCost + next.value;
                if(cost < arr[next.end]) {
                    arr[next.end] = cost;
                    pq.offer(new Pair(next.end, cost));
                }

                
            }
        }
    }
}

