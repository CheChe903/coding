import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int arrDiff[] = new int[N-1];

        for(int i =0; i<N-1; i++) {
            arrDiff[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(arrDiff);

        int answer = 0;
        for(int i = 0 ; i<(N-1) - (K-1); i++) {
            answer+= arrDiff[i];
        }

        System.out.println(answer);


        /*
         * 1 3 5 6 10
         */
    }
}