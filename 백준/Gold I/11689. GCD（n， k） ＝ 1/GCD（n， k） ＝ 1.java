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

                long N = Long.parseLong(br.readLine());

                long result = N;

                for(long p = 2; p*p<=N; p++)
                {
                        if(N%p ==0)
                        {
                                result=result-result/p;
                        }
                        while(N%p==0)
                        {
                                N=N/p;
                        }
                }


                if(N>1)
                {
                        result= result-result/N;
                }


                System.out.println(result);
        }



}
