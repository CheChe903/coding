import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int A[] = new int[N];
        Integer B[] = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int j =0; j<N; j++) {
            B[j]  = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());
        int answer =0;
        for(int i =0; i<N;i++) {
            answer += A[i]*B[i];
        }
        System.out.println(answer);
    }

}
