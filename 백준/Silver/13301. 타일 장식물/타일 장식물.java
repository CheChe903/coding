import java.util.*;
import java.io.*;

public class Main {


    static long answer =0;
    static long arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new long[81];

        arr[1] =1;
        arr[2] =1;

        for(int i =3; i<=N; i++) {
            arr[i] = arr[i-1] +arr[i-2];
        }  
        if(N==1) {
            answer =4;
        }
        else if(N==2)
            answer =6;
        else if(N==3)
            answer =10;
        else
            answer += (arr[N] *3+ arr[N-1]*2 + arr[N-2]*2 +arr[N-3]);  
        
        System.out.println(answer);

    }


}