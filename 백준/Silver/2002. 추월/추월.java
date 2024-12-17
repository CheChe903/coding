import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());

        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            queue.add(br.readLine());
        }

        Set<String> set = new HashSet<>();
        int answer = 0;

        for(int i = 0; i < N; i++) {
            String curCar = br.readLine();

            // 이미 지나간 차량 처리
            while(!queue.isEmpty() && set.contains(queue.peek())) {
                queue.poll();
            }

            // 추월 확인
            if(queue.isEmpty() || !curCar.equals(queue.peek())) {
                answer++;
                set.add(curCar);
            } else {
                queue.poll();
            }
        }

        System.out.println(answer);
    }
}