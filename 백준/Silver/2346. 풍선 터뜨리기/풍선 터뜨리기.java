import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {


	public static class Pair
	{
		int x,y;
		Pair(int x, int y)
		{
			this.x = x;
			this.y =y;
		}
	}
	public static void main(String[] args) throws IOException
	{
		Deque<Pair> deq1 = new ArrayDeque();

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		
		for(int i =1; i<=n; i++)
		{
			deq1.add(new Pair(Integer.parseInt(st.nextToken()), i));
		}
		
		int index =deq1.pollFirst().x;
		System.out.print("1 ");
		for(int j= 0; j<n-1; j++)
		{
			if(index>0)
			{
				for(int i =0; i<index-1; i++)
				{
					deq1.add(deq1.pollFirst());		
				}
				index= deq1.peekFirst().x;
				
				System.out.print(deq1.pollFirst().y+" ");
			}

			else
			{
				for(int i =0; i<(-index)-1; i++)
				{
					deq1.addFirst(deq1.pollLast());
					
				}
				index= deq1.peekLast().x;
				System.out.print(deq1.pollLast().y+" ");
			}

		}

	}


}