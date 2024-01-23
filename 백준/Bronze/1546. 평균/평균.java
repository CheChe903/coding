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

                int N = Integer.parseInt(br.readLine());

                StringTokenizer st = new StringTokenizer(br.readLine()," ");

  
                float[] arr = new float[N];

                for(int i =0; i<N; i++)
                {
                        arr[i] = Float.parseFloat(st.nextToken());
                }

                Arrays.sort(arr);
                float big = arr[N-1];
                float answer =0;
                for(int i =0; i<N; i++)
                {
                        arr[i] = (arr[i]/big)*100;
                        answer+=arr[i];
                }
                answer = answer/N;

                StringBuilder sb =new StringBuilder();
                sb.append(answer);

                System.out.println(sb);

        }


}