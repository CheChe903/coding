import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException
	{
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i =1; i<=n; i++)
		{
			int answer =0;
			st = new StringTokenizer(br.readLine());

			int testCase = Integer.parseInt(st.nextToken());

			int arr[] = new int[20];
			for(int j=0; j<20; j++)
			{
				arr[j]= Integer.parseInt(st.nextToken());
			}

			for(int k =19; k>=0; k--)
			{
				for(int j =0; j<k; j++)
				{
					if(arr[j]> arr[j+1])
					{
						int temp = arr[j];
						arr[j]= arr[j+1];
						arr[j+1] = temp;
						answer++;
					}
				}
			}
			sb.append(testCase).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}



}