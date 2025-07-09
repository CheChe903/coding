import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

    static int parent[];
    static int N,M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];

        for(int i =1; i<=N; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        PriorityQueue<int []> queue = new PriorityQueue<>(Comparator.comparingInt(a1 -> a1[2]));

        for(int i =1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            queue.add(new int[] { u,v,w});
        }

        int answer = 0;
       int edgeCount = 0;
        
        while(!queue.isEmpty() && edgeCount < N - 1) {

            int now[] = queue.poll();

            int parentA = find(now[0]);
            int parentB = find(now[1]);
            if(parentA == parentB) {
                continue;
            }
            if(parentA != parentB) {
                answer += now[2];
                union(now[0], now[1]);
                edgeCount+=1;
            }
        }
        System.out.println(answer);
    }

    static void union(int a, int b) {

        int parentA = find(a);
        int parentB = find(b);

        if(parentA < parentB) {
            parent[parentB] = parentA; 
        }
        else {
            parent[parentA] = parentB;
        }
    }
    static int find(int x) {
        if(parent[x] !=x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}