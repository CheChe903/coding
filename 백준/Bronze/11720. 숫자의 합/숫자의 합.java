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

                String N = br.readLine();
                int n = Integer.parseInt(N);

                String num = br.readLine();
                String[] number = num.split("");

                int answer =0;
                for(int i=0; i<n; i++)
                {
                        answer += Integer.parseInt(number[i]);

                }

                StringBuilder sb = new StringBuilder();

                sb.append(answer);

                System.out.println(sb);

        }


}