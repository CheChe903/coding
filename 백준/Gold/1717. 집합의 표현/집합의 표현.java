import java.io.*;
import java.util.*;

public class Main {
    static int parent[];
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for(int i =1; i<=n; i++) {
            parent[i]= i;
        }
        for(int i =0; i<m; i++) {
            st= new StringTokenizer(br.readLine());

            if(Integer.parseInt(st.nextToken()) == 0) {
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            else {
                boolean check = isSameParent(find(Integer.parseInt(st.nextToken())), find(Integer.parseInt(st.nextToken())));

                if(check)
                    sb.append("YES").append("\n");
                else
                    sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    static void union(int x, int y) {

        x= find(x);
        y= find(y);
 
        if(x!= y) {
            if(x<y) {
                parent[y]=x;
            }
            else {
                parent[x]= y;
            }
        }
    }

    static int find(int x) {
        if(x == parent[x] )
            return x;
        
        return parent[x] = find(parent[x]);
    }

    static boolean isSameParent(int x, int y) {

        x= find(x);
        y =find(y);


        if(x==y) 
            return true;

        return false;

    }
}
