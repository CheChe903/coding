import java.io.*;
import java.util.*;

public class Main {
    static class Pair implements Comparable<Pair>{

        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end =end;
        }

        public int compareTo(Pair other) {

            if(this.start == other.start) {
                return this.end - other.end;
            }
            return this.start - other.start;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        StringTokenizer st;
        long answer =0;
        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int index = pq.peek().start;
        while(!pq.isEmpty()) {
            Pair now = pq.poll();

            if(index <= now.start)
                index = now.start;

            if(index >= now.end)
                continue;
            answer += now.end - index;
            
            index = now.end;
            
        }

        System.out.println(answer);

    }
}