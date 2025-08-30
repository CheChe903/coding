import java.io.*;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger K = BigInteger.ONE.shiftLeft(N).subtract(BigInteger.ONE);
        System.out.println(K);

        if (N <= 20) {
            hanoi(N, 1, 2, 3);
            System.out.print(sb);
        }
    }

    static void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }
        hanoi(n-1, start, end, mid);
        sb.append(start).append(" ").append(end).append("\n");
        hanoi(n-1, mid, start, end);
    }
}
