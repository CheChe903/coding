import java.io.*;
import java.util.*;

public class Main {
    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int answer = 0;
        for(int i =0; i<T; i++) {
            answer = 0;
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());


            Integer A[] = new Integer[N];

            Integer B[] = new Integer[M];
            
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j<N; j++)  {
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for(int j =0; j<M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A,Collections.reverseOrder());
            Arrays.sort(B,Collections.reverseOrder());

            for(int j = 0; j<N; j++) {
                int cur = A[j];
                for(int k = 0; k<M; k++) {
                    if(cur > B[k]) {
                        answer += (M-k);
                        break;
                    }

                }
            }
            //8 7 3 1 1
            //6 3 1
            sb.append(answer+"\n");

        }

        System.out.println(sb);
    }
}
