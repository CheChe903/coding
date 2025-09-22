import java.io.*;
import java.util.*;

public class Main {

    static long dp[][] = new long[31][31];

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if(N==0) break;

            System.out.println(solve(N, 0));
        
        }
    }
    static long solve(int w, int h) {

        if(w == 0 && h ==0) return 1;


        if(dp[w][h] !=0) return dp[w][h];

        long ans = 0;
        if(w !=0) {
            ans += solve(w-1, h+1);
        }
        if(h!=0) {
            ans += solve(w, h-1);
        }
        dp[w][h] = ans;
        return ans;
    }
    /*
     * n==1
     * WH
     * 
     * n==2
     * WWHH, WHWH
     * 
     * n==3
     * WWWHHH, WHWHWH, WWHHWH, WHWWHH, WWHWHH
     */
}
