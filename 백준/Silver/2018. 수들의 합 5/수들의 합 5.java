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

                int count =1;
                int sum =1;
                int start =1;
                int end = 1;

                while(end != N)
                {
                        if(sum ==N)
                        {
                                count++;
                                end++;
                                sum = sum + end;
                        }
                        else if(sum >N)
                        { 
                                sum = sum - start;
                                start++;
                        }
                        else
                        {
                                end++;
                                sum = sum+ end;
                        }
                }

                StringBuilder sb = new StringBuilder();
                sb.append(count);
                System.out.println(count);
                }


}