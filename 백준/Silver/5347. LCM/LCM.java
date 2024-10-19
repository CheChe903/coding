import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i =0;i <T; i++) {
            st = new StringTokenizer(br.readLine());
            long a= Long.parseLong(st.nextToken());
            long b= Long.parseLong(st.nextToken());

            sb.append(lcm(a,b)).append("\n");
        }
        System.out.println(sb);

    }

    public static long gcd(long a, long b) {

        while(!(b==0)) {
            long temp = b;
            b = a%b;
            a=temp;
        }

        return a;
    }

    public static long lcm(long a, long b) {
        return (a*b)/ gcd(a,b);
    }
}