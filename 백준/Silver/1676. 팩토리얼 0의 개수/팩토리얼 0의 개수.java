import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        while(N/5 >=1) {
            answer += N/5;
            N = N/5;
        }
        System.out.println(answer);
    }        
}
