import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i =0; i<T; i++) {

            
            int N=  Integer.parseInt(br.readLine());
            int arr[][] = new int[3][N+1];
            int dp[][] = new int[3][N+1];
            for(int j=1; j<=2; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 1; k<=N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1];

            for(int j = 2; j<=N; j++) {
                dp[1][j] = Math.max(dp[2][j-1], dp[2][j-2] )+ arr[1][j];
                dp[2][j] = Math.max(dp[1][j-1],dp[1][j-2]) + arr[2][j];
            }

            System.out.println(Math.max(dp[1][N],dp[2][N]));

        }
    }
}