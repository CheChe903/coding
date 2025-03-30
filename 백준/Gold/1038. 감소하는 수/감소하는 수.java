import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Long> queue = new LinkedList<>();
        List<Long> list = new ArrayList<>();

        if (N > 1022) {  // 감소하는 수는 최대 1022개 존재
            System.out.println(-1);
            return;
        }

        // 0부터 9까지의 한 자리 숫자 큐에 추가
        for (int i = 0; i <= 9; i++) {
            queue.add((long) i);
            list.add((long) i);
        }

        while (!queue.isEmpty()) {
            long now = queue.poll();

            long lastDigit = now % 10;
            for (int i = 0; i < lastDigit; i++) {  // 마지막 숫자보다 작은 숫자만 뒤에 붙일 수 있음
                long next = now * 10 + i;
                queue.add(next);
                list.add(next);
            }
        }

        Collections.sort(list);  // 증가 순서대로 정렬
        System.out.println(list.get(N));  // N번째 감소하는 수 출력
    }
}
