import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];

        for(int i = 1; i<=N; i++) {
            parent[i] = i;
        }
        for(int i =0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u,v);
        }
        st = new StringTokenizer(br.readLine());
        int currentRoomRoot = find(Integer.parseInt(st.nextToken()));
        int answer = 0;

        for (int i = 1; i < N; i++) {
            int nextRoomRoot = find(Integer.parseInt(st.nextToken()));
            if (currentRoomRoot != nextRoomRoot) {
                answer++;
                currentRoomRoot = nextRoomRoot;
            }
        }

        System.out.println(answer);
    }

    static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB) {
            return;
        }

        if(parentA< parentB) {
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