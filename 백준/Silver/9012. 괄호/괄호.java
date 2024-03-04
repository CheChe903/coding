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

		for(int i =0; i<N; i++)
		{
			boolean good = true;
			Stack<Character> stack = new Stack<>();

			String str = br.readLine();

			for(int j =0; j<str.length(); j++)
			{
				if(str.charAt(j) == '(')
				{
					stack.push(str.charAt(j));
				}
				else if(str.charAt(j) == ')')
				{
					if(!stack.isEmpty())
					{
						stack.pop();
					}
					else if(stack.isEmpty())
					{
						good = false;
						System.out.println("NO");
						break;
					}

				}

			}

			if(good)
			{
				if(stack.isEmpty())
				{
					System.out.println("YES");
				}
	
				else
					System.out.println("NO");
			}

		}



		
	}


}