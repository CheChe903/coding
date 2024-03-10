import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {


	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String str = br.readLine();
		int count =0;
		int answer =0;
		int cur = n-1;
		Queue<Integer> queue = new LinkedList<>();
		for(int i =n-1; i>=0; i--)
		{
			if(str.charAt(i)=='R' && queue.isEmpty())
			{
				cur = i;
			}
			else if(str.charAt(i)== 'B')
			{
				queue.offer(i);
			}
			else if(str.charAt(i)=='R' && !queue.isEmpty())
			{
				count++;
				queue.offer(i);
				queue.remove();
			}
		}
		queue.clear();
		int count2 =0;
		for(int i =n-1; i>=0; i--)
		{
			if(str.charAt(i)=='B' && queue.isEmpty())
			{
				cur = i;
			}
			else if(str.charAt(i)== 'R')
			{
				queue.offer(i);
			}
			else if(str.charAt(i)=='B' && !queue.isEmpty())
			{
				count2++;
				queue.offer(i);
				queue.remove();
			}
		}
		queue.clear();
		int count3=0;
		for(int i =0; i<n; i++)
		{
			if(str.charAt(i)=='R' && queue.isEmpty())
			{
				cur = i;
			}
			else if(str.charAt(i)== 'B')
			{
				queue.offer(i);
			}
			else if(str.charAt(i)=='R' && !queue.isEmpty())
			{
				count3++;
				queue.offer(i);
				queue.remove();
			}
		}

		queue.clear();
		int count4 =0;

		for(int i =0; i<n; i++)
		{
			if(str.charAt(i)=='B' && queue.isEmpty())
			{
				cur = i;
			}
			else if(str.charAt(i)== 'R')
			{
				queue.offer(i);
			}
			else if(str.charAt(i)=='B' && !queue.isEmpty())
			{
				count4++;
				queue.offer(i);
				queue.remove();
			}
		}
		int answer2 = count3 > count4? count4:count3;
		answer = count > count2? count2:count;

		int answer3 = answer2>answer ? answer: answer2; 
		System.out.println(answer3);
	}


}