import java.io.*;
import java.util.*;

public class Main {

    static class Pair{

        public Pair(int x, int y) {
            this.x= x;
            this.y= y;
        } 
        int x;
        int y;

    }


    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        
        Pair pairs[] = new Pair[N];

        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        
        int bags[] = new int[K];

        for(int i =0; i<K; i++) {
            bags[i]= Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        Arrays.sort(pairs, new Comparator<Pair>() {

            @Override
            public int compare(Pair p1, Pair p2) {
                if(p1.x== p2.x) {
                    return p2.y- p1.y;
                }
                return p1.x - p2.x;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());


        long answer =0;

        for(int i =0 ,j =0; i<K; i++) {

            while(j < N && pairs[j].x <= bags[i]) {
                pq.offer(pairs[j++].y);

            }

            if(!pq.isEmpty()) {
                answer += pq.poll();
            }
                
        }

        System.out.println(answer);
    }

}
