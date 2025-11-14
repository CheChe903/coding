import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MAX_VALUE;

        int currentSum = 0;
        int start = 0;
        int end = 0;
        while(start<N) {
            if(end >=N && currentSum <target) break;

            if(currentSum <= target) {
                if(end>=N) break;
                currentSum+=arr[end];
                end+=1;
            } else if(currentSum > target) {
                currentSum-= arr[start];
                start+=1;
            }
            if(currentSum>=target) {
                answer = Math.min(answer, end -start);    
            }
        }
        if(answer == Integer.MAX_VALUE) {
            System.out.println(0);
            System.exit(0);
        }
        System.out.println(answer);
    }

    /*
     * 5 1 3 5 10 7 4 9 2 8
     * 5 6 9 14 24
     * 끝나는 경우, end == start 이면서 end == N-1, end가 N-1인데 target보다 더 적을 때, 
     */
}