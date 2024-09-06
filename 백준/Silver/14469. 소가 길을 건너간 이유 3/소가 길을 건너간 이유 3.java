import java.io.*;
import java.util.*;

public class Main {

    static class Pair implements Comparable<Pair>{

        public Pair(int x, int y) {
            this.x= x;
            this.y= y;
        } 
        private int x;
        private int y;

        @Override
        public int compareTo(Pair other) {
            if (this.x != other.x) {
                return Integer.compare(this.x, other.x);
            }
            return Integer.compare(this.y, other.y);
        }
    }


    public static void main(String[] args) throws Exception {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        PriorityQueue<Pair> queue = new PriorityQueue<>();

        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            queue.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Pair cur = queue.poll();
        int answer = cur.x + cur.y;

        while(!queue.isEmpty()) {
            Pair curPair = queue.poll();

            if(answer >=curPair.x) {
                answer += curPair.y;
            }
            else {
                answer = curPair.x;
                answer += curPair.y;
            }
        }

        System.out.println(answer);
    }

}
