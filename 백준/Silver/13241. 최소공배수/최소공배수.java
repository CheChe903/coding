import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());


        System.out.println(lcm(A,B));
    

        
        

    }
    public static long gcd(long a, long b) {
        while(b!=0) {
            long temp =b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        return a*b / gcd(a,b);
    }
}
