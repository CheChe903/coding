import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            long answer = 0;
            st = new StringTokenizer(br.readLine());
            int arr[] = new int[N+1];
            for(int j = 1; j<=N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int curPrice = arr[N];
            for(int j =N-1; j>=1; j--) {
                if(curPrice  > arr[j]) {
                    answer += (curPrice - arr[j]);
                }
                else if(curPrice < arr[j]) {
                    curPrice = arr[j];
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}  