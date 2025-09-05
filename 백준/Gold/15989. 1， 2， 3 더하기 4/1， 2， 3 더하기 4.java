import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        int[] qs = new int[T];
        int maxN = 0;
        for (int i = 0; i < T; i++) {
            qs[i] = Integer.parseInt(br.readLine());
            if (qs[i] > maxN) maxN = qs[i];
        }

        long[] dp = new long[maxN + 1];
        dp[0] = 1;

        for (int k = 1; k <= 3; k++) {
            for (int n = k; n <= maxN; n++) {
                dp[n] += dp[n - k];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : qs) sb.append(dp[n]).append('\n');
        System.out.print(sb.toString());
    }
}
