import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[N];
        int dp[] = new int[N];
        for(int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        int answer = 0;
        for(int i = 0; i<N; i++) {
            for(int j= 0; j<i; j++) {
                if(arr[i] >arr[j]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        
        System.out.println(answer);
        

    }

}