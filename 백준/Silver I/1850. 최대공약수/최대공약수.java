import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

public class Main {


        public static void main(String[] args) throws IOException 
        {


                BufferedReader br =new  BufferedReader(new InputStreamReader(System.in));

                
                StringTokenizer st= new StringTokenizer(br.readLine());
                long n = Long.parseLong(st.nextToken());
                long m = Long.parseLong(st.nextToken());
                
                long result= gcd(n,m);

                StringBuilder sb =new StringBuilder();
                while(result>0)
                {
                        sb.append("1");
                        result--;
                }

                System.out.println(sb);

        }

        public static long gcd(long a, long b)
        {

                if(b==0)
                        return a;

                else
                        return gcd(b,a%b);
        }

}
