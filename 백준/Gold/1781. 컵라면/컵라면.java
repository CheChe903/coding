import java.io.*;
import java.util.*;

public class Main {
    static class Pair implements Comparable<Pair>{

        int noodle;
        int deadline;

        Pair(int deadline, int noodle) {
            this.noodle= noodle;
            this.deadline=deadline;
        }

        public int compareTo(Pair other) {

            if(this.deadline == other.deadline) {
                return other.noodle - this.noodle;
            }
            return other.deadline - this.deadline;
        }

    }
    public static void main(String[] args) throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        StringTokenizer st;
        for(int i =0; i<N;i++) {
            st= new StringTokenizer(br.readLine());
            int curDeadline = Integer.parseInt(st.nextToken());
            int curNoodle = Integer.parseInt(st.nextToken());
            pq.add(new Pair(curDeadline, curNoodle));

        }
        int index= pq.peek().deadline;
        int answer = 0;
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        while(index != 0) {
            
            while(!pq.isEmpty() && index == pq.peek().deadline) {
                pq2.add(pq.poll().noodle);
            }
            if(!pq2.isEmpty()) {
                answer += pq2.poll();
            }
            
            index--;
        }

        System.out.println(answer);
    }
}





