import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int parent[],N,M;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];

        for(int i =1; i<=N; i++) {
            parent[i] = i;
        }

        for(int i =0; i<M; i++) {
            st= new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }

        int[] count = new int[N+1];

        for(int i =1; i<=N; i++) {
            count[find(i)]++;
        }

        long result = 1;
        for(int i =1; i<=N; i++) {
            if(parent[i] == i) {
                result = (result * count[i]) % MOD; 
            }
        }
        System.out.println(result);
    }

    static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB) return;

        if(parentA < parentB) {
            parent[parentB] = parentA;
        }
        else {
            parent[parentA] = parentB;
        }
    }

    static int find(int x) {
        if(parent[x] !=x) parent[x] = find(parent[x]);
        return parent[x];
    }
}