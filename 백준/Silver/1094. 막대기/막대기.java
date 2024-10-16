import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int answer =0;
        while(X !=0) {
            if(X%2 ==1)
                answer++;
            
            X = X/2;
        }
        System.out.println(answer);


    }
}
