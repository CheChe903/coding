import java.util.*;
import java.io.*;

public class Main {
    static int one;
    static int zero;
    static int zeroOne;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i =0; i<N; i++) {
            int cur = Integer.parseInt(br.readLine());
        
            fibo(cur);

            sb.append(zero).append(" ").append(one).append("\n");
        }
        System.out.println(sb);

    }
    static void fibo(int cur) {

        zero =1;
        one =0;
        zeroOne= 1;

        for(int i =0; i<cur; i++) {
            zero = one;
            one = zeroOne;
            zeroOne = zero+ one;
        }
    }
}