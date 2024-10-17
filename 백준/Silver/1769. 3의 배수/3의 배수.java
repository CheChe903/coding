import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String X = br.readLine();

        int answer= 0;

        while(true) {
            long sum =0;
            if(X.length()==1)
                break;
            
            for(int i =0; i<X.length(); i++) {
                sum += Long.parseLong(String.valueOf(X.charAt(i)));
            }
            answer++;
            X = String.valueOf(sum);

        }
        System.out.println(answer);
        if(Long.parseLong(String.valueOf(X)) % 3 ==0) 
            System.out.println("YES");
        else
            System.out.println("NO");


    }


}