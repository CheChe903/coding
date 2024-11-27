import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N+1];
        int[] path = new int[N + 1];

        dp[1] =0;
        path[1] = 0;

        if(N>=2) {
            dp[2] =1;
            path[2] = 1;
        }
            
        if(N>=3) {
            dp[3] =1;
            path[3] =1;
        }


        for(int i =4; i<=N; i++) {

            dp[i] = dp[i-1]+1;
            path[i] = i-1;
            
            if(i%3 ==0 && dp[i] > dp[i/3]+1) {
                dp[i] =dp[i/3] +1;
                path[i] = i/3;
            }
            if(i%2 ==0 && dp[i] > dp[i/2]+1) {
                dp[i] = dp[i/2]+1;
                path[i]=  i/2;
            }
        }
        int answer = dp[N];
        StringBuilder sb = new StringBuilder();
        System.out.println(answer);

        int current = N;
        while(current > 0 ) {
            sb.append(current).append(" ");
            current  = path[current];
        }

        System.out.println(sb);
    }
}
