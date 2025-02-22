import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        sb.append((int) (Math.pow(2,K ) -1)).append("\n");

        hanoi(K,1,2,3);
        System.out.println(sb);
    }
    
    static void hanoi(int K, int start, int mid, int to) {

        if(K ==1) {
            sb.append(start +" " +to +"\n");
            return;
        }

        hanoi(K-1, start, to, mid);

        sb.append(start + " " + to +"\n");

        hanoi(K-1, mid, start, to);
    } 

}