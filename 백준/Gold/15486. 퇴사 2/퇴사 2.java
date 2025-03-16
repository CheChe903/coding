import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int T[] = new int[N+2];
        int P[] = new int[N+2];

        for(int i =1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        int dp[] = new int[N+2];

        if(T[N] ==1) {
            dp[N] = P[N];
        }
        for(int i= N;i >=1; i--) {
            if(T[i] + i >N+1) {
                dp[i] = dp[i+1];
                continue;
            }
            dp[i] = Math.max(dp[i+1], dp[i+T[i]]+P[i]);
        }

        int answer = Integer.MIN_VALUE;
        for(int i= 1;i <=N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);


    }


}