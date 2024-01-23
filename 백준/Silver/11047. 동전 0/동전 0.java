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
                
                
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                int[] input = new int[2];
                int answer =0;
                for(int i =0; i<2; i++)
                {
                        input[i]= Integer.parseInt(st.nextToken());
                }

                int[] coin = new int[input[0]];
                for(int i =0; i<input[0]; i++)
                {
                        coin[i] = Integer.parseInt(br.readLine());
                }
                
                for(int i =input[0]-1; i>=0; i--)
                {
                        while(input[1]/coin[i]>=1)
                        {
                                input[1]= input[1] - coin[i];
                                answer++;
                        }
                }

                StringBuilder sb = new StringBuilder();

                sb.append(answer);

                System.out.println(sb);


        }


}