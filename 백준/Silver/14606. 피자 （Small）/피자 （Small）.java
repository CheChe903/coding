import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());

        solve(N);
        System.out.println(answer);
    }  

    public static void solve(int A) {

        if(A==1)
            return;
        int B = A/2;
        int C = A-B;

        answer += (B*C);
        solve(B);
        solve(C);

    }

}
  