import java.io.*;
import java.util.*;

public class Main {

    static class Pair implements Comparable<Pair>{
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.start == other.start) {
                return this.end - other.end;
            }
            return this.start - other.start;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Pair(start, end));
        }

        int fill = 0;
        int answer = 0;

        while (!pq.isEmpty()) {
            Pair now = pq.poll();
            if (now.end <= fill) continue;

            fill = Math.max(fill, now.start);

            int remain = (now.end - fill) % L;
            answer += (now.end - fill) / L;

            fill = now.end;
            if (remain != 0) {
                answer++;
                fill += L - remain; 
            }
        }

        System.out.println(answer);
    }
}
