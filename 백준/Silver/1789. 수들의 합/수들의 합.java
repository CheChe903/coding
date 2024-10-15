import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long answer = 0;

        while(answer *answer +answer <= N*2) {
            answer++;
        }
        System.out.println(answer-1);
    }        
}
