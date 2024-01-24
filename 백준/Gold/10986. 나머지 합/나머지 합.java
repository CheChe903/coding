import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;


public class Main {

	public static void main(String[] args) throws IOException 
        {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                StringTokenizer st = new StringTokenizer(br.readLine());

                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());

                long[] arr = new long[N];
                long[] D = new long[M];

                long answer =0;
                st = new StringTokenizer(br.readLine());
                arr[0]= Integer.parseInt(st.nextToken());
                for(int i =1; i<N; i++)
                {
                        arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
                }

                for(int i =0; i<N; i++)
                {
                        int remainder = (int) (arr[i]%M);
                        if(remainder ==0)
                                answer++;

                        D[remainder]++;
                } 

                for(int i =0; i<M; i++)
                {
                        if(D[i]>1)
                        {
                                answer = answer + (D[i] * (D[i] -1)/2);
                        }
                }
                StringBuilder sb = new StringBuilder();

                sb.append(answer);

                System.out.println(sb);
        }


}