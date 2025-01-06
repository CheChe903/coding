import java.io.*;
import java.util.*;

public class Main {
    static int answer;
    static int cur;
    static int arr[] = new int[1000001];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        arr[1]=1;
        arr[2]=2;
        arr[3] =4;
        StringBuilder sb = new StringBuilder();
        for(int i =4; i <=1000000; i++) {
            arr[i] = ((arr[i-1] + arr[i-2])%1000000009 + arr[i-3])%1000000009;
        }  

        for(int i =0; i<T; i++) {
            int cur = Integer.parseInt(br.readLine());
            System.out.println(arr[cur]%1000000009);
        }
    }
}
