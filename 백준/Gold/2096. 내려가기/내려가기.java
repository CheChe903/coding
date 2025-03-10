import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int arr[][]= new int[N][3];
        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dp[][] = new int[N][3];
        int dp2[][] = new int[N][3];

        for(int i =0; i<3; i++) {
            dp[0][i] = arr[0][i];
            dp2[0][i] = arr[0][i];
        }

        for(int i =1 ; i<N; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) +arr[i][0];
            dp[i][1] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])) +arr[i][1];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]) +arr[i][2];

            dp2[i][0] = Math.min(dp2[i-1][0], dp2[i-1][1]) +arr[i][0];
            dp2[i][1] = Math.min(dp2[i-1][0], Math.min(dp2[i-1][1], dp2[i-1][2])) +arr[i][1];
            dp2[i][2] = Math.min(dp2[i-1][1], dp2[i-1][2]) +arr[i][2];
        }

        System.out.print(Math.max(dp[N-1][0], Math.max(dp[N-1][1],dp[N-1][2]))+" ");
        System.out.println(Math.min(dp2[N-1][0], Math.min(dp2[N-1][1],dp2[N-1][2])));

    }
        /*
         * 3
         * 1  2   3
         * 6  8   9
         * 12 18  9
         */

         /*
          * 1 0  0
            5 6  0
            9 14 6

          *  
          */
    
}