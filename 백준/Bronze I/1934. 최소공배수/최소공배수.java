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

                int N = Integer.parseInt(br.readLine());
                
                StringTokenizer st;

                StringBuilder sb =new StringBuilder();
                for(int i =0; i<N; i++)
                {
                        st =new StringTokenizer(br.readLine());
                        int A = Integer.parseInt(st.nextToken());
                        int B = Integer.parseInt(st.nextToken());

                        int max= A>B?A:B;
                        int min = A>B?B:A;
                        int cur =max;
                        while(true)
                        {
                                if(cur%min==0)
                                {
                                        sb.append(cur).append("\n");
                                        break;
                                }
                                else
                                        cur=cur+max;
                        }
                }

                System.out.println(sb);

        }



}
