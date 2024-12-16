import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        long answer = 0;
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int snack[] = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i =0;i <N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(snack);

        long start = 1;
        long end = snack[N-1];
        while(start<=end) {
            
            long mid = (start + end ) /2;
            int count =  0;
            for(int i =0; i<N; i++) {  
                count += snack[i]/mid;
            }

            if(count >=M) {
                answer = Math.max(answer, mid);
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        
        }

        System.out.println(answer);

    }
}