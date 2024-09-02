import java.util.*;
import java.io.*;

public class Main {

    static int answer;
    static ArrayList<Character> op;
    static ArrayList<Integer> num;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        op = new ArrayList<>(); 
        num = new ArrayList<>();  

        for (int i = 0; i < N; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                op.add(c);
            } else {
                num.add(c - '0'); 
            }
        }

        answer = Integer.MIN_VALUE;

        dfs(num.get(0), 0);

        System.out.println(answer);
    }

    static int calc(char op, int n1, int n2) {
        switch (op) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
        }
        return -1; 
    }

    static void dfs(int currentValue, int index) {
        if (index >= op.size()) {
            answer = Math.max(answer, currentValue);
            return;
        }


        int res1 = calc(op.get(index), currentValue, num.get(index + 1));


        dfs(res1, index + 1);

        if (index + 1 < op.size()) {
            int res2 = calc(op.get(index + 1), num.get(index + 1), num.get(index + 2));
            dfs(calc(op.get(index), currentValue, res2), index + 2);
        }
    }
}
