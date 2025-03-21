import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i =0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());

            int coins[] = new int[N+1];

            st = new StringTokenizer(br.readLine());

            for(int j = 1; j<=N; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int dp[] = new int[M+1];

            for(int k = 1; k<=N; k++) {
                for(int h = 1; h<=M; h++) {
                    if(h - coins[k] >0) {
                        dp[h] = dp[h] + dp[h-coins[k]];
                    }
                    else if(h - coins[k] ==0 ) {
                        dp[h]++;
                    }
                }
            }
            System.out.println(dp[M]);
        }

        
        



    }


}