import java.util.*;
import java.io.*;

public class Main {
    static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i =0; i <N; i++) {
            count = 0;
            int cur = Integer.parseInt(br.readLine());
            
            for(int j=1; j<=3; j++) {
                solve(j, cur);
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static void solve(int j, int cur) {

        if(j == cur) {
            count++;
            return;
        }
        else if(j > cur) 
            return;
        
        solve(j+1,cur);
        solve(j+2,cur);
        solve(j+3,cur);
    }
}