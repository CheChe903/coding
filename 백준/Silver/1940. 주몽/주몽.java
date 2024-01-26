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
                int M = Integer.parseInt(br.readLine());
                
                int count =0;
                int start =0;
                int end = N-1;
                int []arr = new int[N];

                StringTokenizer st = new StringTokenizer(br.readLine()," ");

                for(int i =0; i<N; i++)
                {
                        arr[i] = Integer.parseInt(st.nextToken());
                }
                Arrays.sort(arr);

                while(start < end)
                {

                        if(arr[start]+arr[end]<M)
                        {
                                start++;
                        }
                        else if(arr[start]+arr[end]>M)
                        {
                                end--;
                        }
                        else
                        {
                                count++;
                                start++;
                                end--;
                        }
                }

                StringBuilder sb = new StringBuilder();
                sb.append(count);
                System.out.println(count);
                }


}