import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.*;
public class Main {

 
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		int answer =0;
		for(int i =0; i<N; i++)
		{
			int cur = Integer.parseInt(br.readLine());


			if( cur != 0)
			{
				answer += cur;
				stack.push(cur);
			}
			else
			{
				answer -=stack.peek();
				stack.pop();
			}
		}

		System.out.println(answer);

	}


}