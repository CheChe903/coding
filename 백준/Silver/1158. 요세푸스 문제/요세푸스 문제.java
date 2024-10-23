import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer>queue = new LinkedList<>();

        for(int i =1; i <=N; i++) {
            queue.add(i);
        }
        int index = 1;
        ArrayList<Integer>list  = new ArrayList<>();
        while(!(queue.size() == 0)) {

            if(index != K) {
                int cur = queue.poll();
                queue.add(cur);
                index++;
            }
            else if(index ==K) {
                int cur = queue.poll();
                list.add(cur);
                index=1;
            }
        }
        System.out.print("<");

        for(int i =0; i<N-1; i++) {
            System.out.print(list.get(i)+", ");
        }
        System.out.print(list.get(N-1));
        System.out.print(">");
    }
}
