import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int parent[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        parent = new int[N+1];

        for(int i =1; i<=N; i++) {
            parent[i] = i;
        }

        for(int i=0; i<N-2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u,v);
        }

        String answer = "";
        for(int i = 1; i<=N; i++) {
            if(find(i) ==i) {
                answer+= i+" ";
            }
        }
        System.out.println(answer);
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
        if(parent[x] !=x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}