import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        if(n == 1 || n==3) {
            System.out.println(-1);
            System.exit(0);
        }
        int answer = 0;

        answer += n/5;
        n = n%5;

        answer += n/2;
        n = n%2;

        if(n !=0) {
            n+=5;
            answer --;
            answer +=n/2;
            n= n%2;
        }

        answer = n==0 ? answer : -1;

        System.out.println(answer);

    
    }

}
