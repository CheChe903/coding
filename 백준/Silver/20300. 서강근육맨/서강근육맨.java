import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long arr[] = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =0; i<N;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int start =-1;
        int end = 1;
        long M = -1;

        if(arr.length %2 ==0) {
            start =0;
            end = arr.length -1;
            M = arr[start] + arr[end];
        }
        else{
            start = 0;
            end = arr.length -2;
            M = arr[arr.length-1];
        }

        while(start < end) {
            if(arr[start]+ arr[end] > M) {
                M = arr[start]+arr[end];
            }
            start++;
            end--;
        }

        System.out.println(M);
        
    }

}