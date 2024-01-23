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

                StringTokenizer st = new StringTokenizer(br.readLine()," ");

                int N= Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine()," ");
                int[] arr = new int[N+1];
                int[] sum = new int[N+1];
                int[] answer= new int[M];
                arr[0]=0;
                sum[0]=0;
                for(int i=1; i<=N; i++)
                {
                        arr[i]=Integer.parseInt(st.nextToken());
                        if(i>0)
                        {
                                sum[i]= sum[i-1] + arr[i];
                        }
                        else
                        {
                                sum[i] = arr[i];
                        }
                }

                StringBuilder sb = new StringBuilder();

                for(int i=0; i<M; i++)
                {
                        st = new StringTokenizer(br.readLine());
                        int start = Integer.parseInt(st.nextToken());
                        int end = Integer.parseInt(st.nextToken());

                        answer[i] = sum[end] - sum[start-1];
                        sb.append(answer[i]).append('\n');
                }



                System.out.println(sb);
        }


}