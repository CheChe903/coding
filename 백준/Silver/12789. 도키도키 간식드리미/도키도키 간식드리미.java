import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.*;
public class Main {

 
	public static void main(String[] args) throws IOException
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n= Integer.parseInt(br.readLine());

		StringTokenizer st =new StringTokenizer(br.readLine());

		int []arr = new int[n];
		for(int i =0; i<n; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());

		}

		Stack<Integer> cur = new Stack<>();
		Stack<Integer> umm = new Stack<>();
		Stack<Integer> good = new Stack<>();

		for(int i =n-1; i>=0; i--)
		{
			cur.push(arr[i]);
		}

		int curumm=999999;
		int num =1;
		boolean answer =true;

		while(!(good.size()==n))
		{
			if(!cur.isEmpty() && cur.peek()==num)
			{
				cur.pop();
				good.push(num);
				num++;
			}
			else if(!umm.isEmpty() && umm.peek() == num)
			{
				good.push(umm.peek());
				umm.pop();
				if(!umm.isEmpty())
					curumm= umm.peek();
				num++;
				if(umm.isEmpty())
				{
					curumm=9999999;
				}
			}

			else if(!cur.isEmpty() && cur.peek() !=num)
			{
				if(curumm < cur.peek())
				{
					System.out.println("Sad");
					answer = false;
					break;
				}
				else
				{
					umm.push(cur.peek());
					curumm= umm.peek();
					cur.pop();
				}
			}
			


		}


		if(answer)
			System.out.println("Nice");

	}


}