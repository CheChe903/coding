import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String input = br.readLine();

        double[] arr = new double[N+1];
        for(int i =0; i<N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        Stack<Double> stack = new Stack<>();

        for(int i =0; i< input.length(); i++) {
            Character c = input.charAt(i);
            if(Character.isAlphabetic(c)) {
                stack.add(arr[c - 65]);
            } else {
                double c2 = stack.pop();
                double c1 = stack.pop();
                if(c == '*') {
                    stack.add(c1 * c2);
                } else if(c == '+') {
                    stack.add(c1 + c2);
                } else if(c == '/') {
                    stack.add(c1/c2);
                } else {
                    stack.add(c1-c2);
                }
            }
        }
        System.out.printf("%.2f\n", stack.peek());
    }
}