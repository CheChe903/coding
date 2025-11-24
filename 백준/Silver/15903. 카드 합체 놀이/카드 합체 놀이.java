import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N=  Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        for(int i =0; i<M; i++) {
            Long cur1 = pq.poll();
            Long cur2 = pq.poll();

            pq.add(cur1+cur2);
            pq.add(cur1+cur2);
        }
        Long answer = 0L;
        while(!pq.isEmpty()) {
            answer+= pq.poll();
        }
        System.out.println(answer);
    }
}
