import java.util.*;
import java.io.*;

public class Main {
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        arr = new int[246913]; 
        
    
        func();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;

            int count = 0;

            
            for (int i = n + 1; i <= 2 * n; i++) {
                if (arr[i] == 0)
                    count++;
            }

            System.out.println(count);
        }
    }

    static void func() {
        
        for (int i = 2; i <= 246912; i++) {
            if (arr[i] == 0) {
                for (int j = i + i; j <= 246912; j += i) {
                    arr[j] = 1;
                }
            }
        }
    }
}
