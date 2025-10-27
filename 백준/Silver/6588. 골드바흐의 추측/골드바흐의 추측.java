import java.io.*;
import java.util.*;

public class Main {

    static boolean isPrime[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i*i  <=1000000; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= 1000000; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        while(true) {
            int N = Integer.parseInt(br.readLine());

            if(N ==0) break;

            boolean found = false;
            for(int i = 3; i <=N/2; i+=1) {
                if(isPrime[i] &&isPrime[N-i]) {
                    System.out.println(N + " = " + i + " + " + (N-i));
                    found = true;
                    break;
                }
            }
            if(!found) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
            
        }
    }
}
