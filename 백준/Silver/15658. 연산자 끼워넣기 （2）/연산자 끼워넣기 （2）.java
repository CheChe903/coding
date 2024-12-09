import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] op;
    static int maxAnswer = Integer.MIN_VALUE;
    static int minAnswer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);

        System.out.println(maxAnswer);
        System.out.println(minAnswer);
    }

    static void dfs(int depth, int currentNum) {
        if (depth == N) {
            maxAnswer = Math.max(maxAnswer, currentNum);
            minAnswer = Math.min(minAnswer, currentNum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] >= 1) {
                op[i]--;
                
                int newCurrentNum = Oper(i, currentNum, arr[depth]);
                
                dfs(depth + 1, newCurrentNum);
                
                op[i]++;
            }
        }
    }

    static int Oper(int index, int num1, int num2) {
        switch (index) {
            case 0: return num1 + num2;
            case 1: return num1 - num2;
            case 2: return num1 * num2;
            case 3: return num1 / num2;
            default: throw new IllegalArgumentException("Invalid operator index");
        }
    }
}