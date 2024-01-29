import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.*;
public class Main {


	public static void main(String[] args) throws IOException 
        {
  
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int N= Integer.parseInt(br.readLine());

                int arr[] =new int[N];

                StringTokenizer st =new StringTokenizer(br.readLine());
                for(int i =0; i<N; i++)
                {
                        arr[i]= Integer.parseInt(st.nextToken());
                }

                Arrays.sort(arr);

                int answer =0;
                int []answer2 = new int[N];
                answer2[0] = arr[0]; 
                answer +=answer2[0];
                for(int i =1; i<N; i++)
                {
                        answer2[i]= answer2[i-1]+arr[i];
                        answer+=answer2[i];

                }
                
                StringBuilder sb =new StringBuilder();
                sb.append(answer);

                System.out.println(sb);
        }
}

