import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {

 
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Queue<Integer> queue1 = new LinkedList<>();

		StringTokenizer st =new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for(int i =1; i<=n; i++)
		{
			queue1.add(i);
		}	
		
		System.out.print("<");
		for(int i =0; i<n; i++)
		{
			for(int j=0; j<m-1; j++)
			{
				queue1.add(queue1.poll());

			}
			if(i!=n-1)
				System.out.print(+queue1.poll()+", ");
			else
				System.out.print(queue1.poll());
		}

		System.out.print(">");

	}


}
