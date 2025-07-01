import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M,X;
    static ArrayList<int []> A[];
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];

        for(int i =1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i =0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            A[u].add(new int[]{ v,w});
        }

        int answer = Integer.MIN_VALUE;
        for(int i =1; i<=N; i++) {
            if(i ==X) continue;
            answer = Math.max(answer, dijkstra(i, X) + dijkstra(X, i));
        }

        System.out.println(answer);
    }
    static int dijkstra(int startNode, int endNode) {

        int diff[] = new int[N+1];

        Arrays.fill(diff, INF);

        diff[startNode] = 0;

        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.add(new int[] {startNode, 0});

        while(!pq.isEmpty()) {

            int now[] = pq.poll();
            
            int currentNode= now[0];
            int currentValue = now[1];

            if(diff[currentNode] < currentValue) {
                continue;
            }
            for(int next[]: A[currentNode]) {
                int nextNode = next[0];
                int nextValue = next[1];

                if(diff[nextNode] > diff[currentNode] + nextValue) {
                    diff[nextNode] = diff[currentNode] + nextValue;
                    pq.add(new int[] {nextNode, diff[nextNode]});
                }
            }
        }
        return diff[endNode];
    }
}
