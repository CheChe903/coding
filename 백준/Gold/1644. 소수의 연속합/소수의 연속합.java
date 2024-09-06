import java.io.*;
import java.util.*;

public class Main {

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N + 1];  
        int sum[] = new int[N + 1];  
        int index = 0;

        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) {
                arr[index++] = i; 
            }
        }

        for (int i = 0; i <= N; i++) {
            int curSum = 0;
            for (int j = i; j < index; j++) {
                curSum += arr[j];
                if (curSum > N) break;
                sum[curSum]++;
            }
        }
        System.out.println(sum[N]);
    }
}
