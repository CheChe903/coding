import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 1;i <=N; i++) {
            queue.add(i);
        }
        int index= 0;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            index+=1;
            if(index == K) {
                if(!queue.isEmpty()) {
                    sb.append(temp).append(", ");
                } else {
                    sb.append(temp);
                }
                index =0;
            } else {
                queue.add(temp);
            }
            
        }

        sb.append(">");

        System.out.println(sb);
    }
}