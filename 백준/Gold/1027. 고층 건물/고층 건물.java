import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i =0; i<N; i++) {
            int cnt = 0;
            double lean = Double.NEGATIVE_INFINITY;
            for(int j = i+1; j<N; j++) {
                double x = j-i;
                double y = arr[j] - arr[i];

                double tempLean = y/x;

                if(tempLean > lean) {
                    lean = tempLean;
                    cnt+=1;
                }
            }
            
            lean = Double.POSITIVE_INFINITY;

            for(int j = i-1; j>=0; j--) {
                double x = j-i;
                double y = arr[j] - arr[i];

                double tempLean = y/x;

                if(tempLean < lean) {
                    lean = tempLean;
                    cnt+=1;
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}

/*
 * 1 5 3 2 6 3 2 6 4 2 5 7 3 1 5
 * 
 */