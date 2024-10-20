import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer= 0;         
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine()); 
            int C = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            answer += C*K;
        }

        System.out.println(answer);
        
    }  

}
