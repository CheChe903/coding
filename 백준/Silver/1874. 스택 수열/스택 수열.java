import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Stack;
public class Main {


	public static void main(String[] args) throws IOException 
        {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                boolean result = true;
                StringBuilder sb = new StringBuilder();

                Stack<Integer> stack = new Stack<>();

                int N = Integer.parseInt(br.readLine());

                int cur =1;
                for(int i =0; i<N; i++)
                {

                        int n = Integer.parseInt(br.readLine());

                        if(n>=cur)
                        {
                                while(n>=cur)
                                {
                                        stack.push(cur++);
                                        sb.append("+\n");

                                }
                                stack.pop();
                                sb.append("-\n");
                        }
                        else
                        {
                                int a= stack.pop();

                                if(a>n)
                                {
                                     System.out.println("NO");
                                     result = false;
                                     break;
                                }
                                else
                                {
                                        sb.append("-\n");
                                }
                        }
                        


                }



                if(result) System.out.println(sb);
        }
}

