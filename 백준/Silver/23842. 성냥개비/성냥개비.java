import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] matchsticks = {6, 2, 5, 5, 4, 5, 6, 4, 7, 6};
        
        int symbolMatches = 4;  
        
        for (int a = 0; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) {
                    for (int d = 0; d <= 9; d++) {
                        int sum = (a * 10 + b) + (c * 10 + d);
                        
                        if (sum >= 100) continue;
                        
                        int totalMatches = matchsticks[a] + matchsticks[b] + 
                                         matchsticks[c] + matchsticks[d] +   
                                         matchsticks[sum/10] + matchsticks[sum%10] +
                                         symbolMatches; 
                        
                        if (totalMatches == N) {
                            System.out.printf("%d%d+%d%d=%d%d\n", a, b, c, d, sum/10, sum%10);
                            return;
                        }
                    }
                }
            }
        }
        
        System.out.println("impossible");
    }
}