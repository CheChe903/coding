import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long arr[] = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int start = 0;
        int end = N-1;
        long answerStart = 0;
        long answerEnd = N-1;

        long answer = Long.MAX_VALUE;


        while(start < end) {
            long sum = arr[start] + arr[end];
            if(sum == 0) {
                answer = sum;
                answerStart = arr[start];
                answerEnd = arr[end];
                break;
            }
            else if(sum > 0) {
                if(Math.abs(answer) > Math.abs(sum)) {
                    answer = sum;
                    answerStart = arr[start];
                    answerEnd = arr[end];
                }
                end--;
            }
            else {
                if(Math.abs(answer) > Math.abs(sum)) {
                    answer = sum;
                    answerStart = arr[start];
                    answerEnd = arr[end];
                }
                start++;
            }
        }

        System.out.println(answerStart + " " + answerEnd);
    }
}