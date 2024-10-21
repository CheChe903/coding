import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N < 10) {
            System.out.println(N);
            System.exit(0);
        }
        int answer = 9;
        for(int i =10; i<=N; i++) {
            if(solve(Integer.toString(i)))
                answer++;
        }
        System.out.println(answer);
        
    }  
    public static boolean solve(String n) {

        int diff = (n.charAt(1) -'0') - (n.charAt(0)-'0');
        for(int i =2; i<n.length(); i++) {
            int curDiff = (n.charAt(i) -'0') - (n.charAt(i-1)-'0');

            if(diff != curDiff)
                return false;
        }

        return true;
    }

}
