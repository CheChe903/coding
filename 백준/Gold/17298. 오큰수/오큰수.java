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

                int N = Integer.parseInt(br.readLine());

                StringTokenizer st = new StringTokenizer(br.readLine());

                int[] arr =new int[N];
                int[] arr2 = new int[N];
                StringBuilder sb =new StringBuilder();

                Stack<Integer> stack = new Stack<>();

                for(int i =0; i<N; i++)
                {
                        arr[i]=Integer.parseInt(st.nextToken());
                }

                stack.push(0);

                for(int i =1; i<N; i++)
                {
                        while(!stack.empty() && arr[stack.peek()]<arr[i])
                        {
                                arr2[stack.pop()]= arr[i];
                        }
                        stack.push(i);

                }

                while(!stack.empty())
                {
                        arr2[stack.pop()]= -1;
                }
                for(int i =0; i<N; i++)
                {
                        sb.append(arr2[i]).append(" ");
                }

                System.out.println(sb);
        }
}

