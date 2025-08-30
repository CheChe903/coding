import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek() <= now) {
                stack.pop();
            }

            answer += stack.size();
            stack.push(now);
        }

        System.out.println(answer);
    }
}
