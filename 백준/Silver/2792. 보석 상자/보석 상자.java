import java.io.*;
import java.util.*;

public class Main {

    static int arr[];
    static int N,M,maxJew;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M+1];
        maxJew= -1;

        for(int i = 1; i<=M; i++) {

            arr[i] = Integer.parseInt(br.readLine());
            maxJew= Math.max(arr[i], maxJew);
        }
    
        Arrays.sort(arr);
        int answer = binarySearch(N, M);
        System.out.println(answer);
    }        
    

    static int binarySearch(int n, int m ) {
    
        int min = Integer.MAX_VALUE;
        int low = 1;
        int high = maxJew;

        while(low <= high) {
            int mid = (high + low ) /2;
            int sum = 0;

            for(int element: arr) {
                int people = element % mid ==0 ? element/mid : element/mid +1;

                sum += people;
            }


            if(n >=sum ) {
                min = Math.min(min,mid);
                high= mid -1;
            }
            else {
                low = mid +1;
            }
        }

        return min;
    
    }
}