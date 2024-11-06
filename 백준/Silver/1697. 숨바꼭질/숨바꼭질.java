import java.util.*;
import java.io.*;

public class Main {
    static int N,K;
    static int visitied[] = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = bfs(N);

        System.out.println(result);
    }

    static int bfs(int n) {

        Queue<Integer> queue= new LinkedList<>();

        queue.add(n);

        while(!queue.isEmpty()) {
                int cur = queue.poll();
                if(cur == K) {
                    return visitied[cur];
                }

                if(cur -1 >=0 && visitied[cur-1]==0) {
                    visitied[cur-1] = visitied[cur]+1;
                    queue.add(cur-1);
                }
                if(cur +1 <=100000 && visitied[cur+1]==0) {
                    visitied[cur+1] = visitied[cur]+1;
                    queue.add(cur+1);
                }
                if(cur *2 <=100000 && visitied[cur*2]==0) {
                    visitied[cur*2] = visitied[cur]+1;
                    queue.add(cur*2);
                }

        }

        return -1;
    }
}