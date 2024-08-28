import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N+2];

        arr[1] =0;
        arr[2]= 1;


        for(int i = 3; i<=N; i++) {
            arr[i] = arr[i-1] +1;

            if(i%2 == 0) {
                arr[i]= Math.min(arr[i],arr[i/2]+1);
            }
            if(i%3 ==0) {
                arr[i] = Math.min(arr[i],arr[i/3]+1);
            }

        }

        System.out.println(arr[N]);
    }

}
