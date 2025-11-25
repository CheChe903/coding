import java.io.*;
import java.util.*;

public class Main {
    static int MOD = 1000000009;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int maxN = 0;

        List<Integer> input = new ArrayList<>();
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            maxN = Math.max(maxN, N);
            input.add(N);
        }

        long dp[][] = new long[maxN + 1][4];
        
        // 초기값 설정
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        
        // DP 계산
        for(int i = 4; i <= maxN; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % MOD;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % MOD;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % MOD;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int now : input) {
            long answer = (dp[now][1] + dp[now][2] + dp[now][3]) % MOD;
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
}