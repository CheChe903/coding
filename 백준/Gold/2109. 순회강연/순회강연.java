import java.io.*;
import java.util.*;

public class Main {


    public static class Pair implements Comparable<Pair>{
        private int x;
        private int y;

        Pair(int x, int y) {
            this.x= x;
            this.y =y;
        }
        public int getX(){
            return x;
        }
        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.x != other.x) {
                return Integer.compare(other.x, this.x);
            }
            return Integer.compare(other.y, this.y);
        }
    }
    public static void main(String[] args) throws Exception {

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int answer= 0;
        StringTokenizer st;
        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            Pair pair = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            pq.add(pair);
        }
		boolean[] visited = new boolean[10001];
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();

            for(int i = pair.y; i >=1; i--) {
                if(visited[i] ==false) {
                    visited[i]= true;
                    answer += pair.x;
                    break;
                }
            }
            
        }

        System.out.println(answer);
    }
}