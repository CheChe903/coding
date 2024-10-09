import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st;
        for(int i =0; i<N;i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++) {
                int cur = Integer.parseInt(st.nextToken());

                if(pq.size() <N) {
                    pq.add(cur);
                }
                else if(pq.size() == N) {
                    if(pq.peek() <cur) {
                        pq.poll();
                        pq.add(cur);
                    }
                }
            }
        }


        System.out.println(pq.peek());




    }
}
