import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

public class Main {


        public static void main(String[] args) throws IOException 
        {

                BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st =new StringTokenizer(br.readLine());

                long min = Long.parseLong(st.nextToken());
                long max = Long.parseLong(st.nextToken());

                boolean[] Check = new boolean[(int)(max-min+1)];

                for(long i = 2; i*i<=max; i++)
                {
                        long pow = i*i;
                        long start_index = min/pow;
                        if(min%pow !=0)
                        {
                                start_index++;
                        }
                        for(long j = start_index; pow*j <=max; j++)
                        {
                                Check[(int) ((j*pow)-min)]=true;
                        }
                }

                int count =0;
                for(int i =0; i<=max-min; i++)
                {
                        if(!Check[i])
                                count++;
                }

                System.out.println(count);


        }


}
