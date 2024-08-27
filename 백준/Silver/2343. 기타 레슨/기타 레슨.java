import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N+1];

        int start =0;
        int end =0;

        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if(start < arr[i]) start =arr[i];
            
            end += arr[i];
        }

        while(start < end) {

            int middle = (start + end ) / 2;
            int sum =0;
            int count =0;
            for(int i =1; i<=N; i++) {
                if(sum + arr[i] > middle) {
                    count++;
                    sum =0;
                }
                sum += arr[i];
            }

            if(sum !=0)
                count++;
            
            if(count >M)
                start = middle+1;
            else
                end = middle;
        }

        System.out.println(start);

        
   }

}