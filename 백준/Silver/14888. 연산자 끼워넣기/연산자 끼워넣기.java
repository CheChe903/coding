import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N;
    static int[] op;
    static int answerMax = Integer.MIN_VALUE;
    static int answerMin = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        
        solve(1, arr[0]);
        
        System.out.println(answerMax);
        System.out.println(answerMin);
    }
    
    static void solve(int depth, int result) {
        if (depth == N) {
            answerMax = Math.max(answerMax, result);
            answerMin = Math.min(answerMin, result);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                switch (i) {
                    case 0: solve(depth + 1, result + arr[depth]); break;
                    case 1: solve(depth + 1, result - arr[depth]); break;
                    case 2: solve(depth + 1, result * arr[depth]); break;
                    case 3: solve(depth + 1, result / arr[depth]); break;
                }
                op[i]++;
            }
        }
    }
}