
import java.io.*;
import java.util.*;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		String pattern = br.readLine();

		for(int i =0; i<N; i++)
		{
			String cur = br.readLine();

			String[] mypattern = pattern.split("\\*", 2);

			if(cur.length() < mypattern[0].length() || cur.length() < mypattern[1].length() || cur.length() < mypattern[0].length() + mypattern[1].length())
				{
					sb.append("NE\n");
					continue;
				}
			String first = cur.substring(0, mypattern[0].length());

			String second = cur.substring(cur.length()-mypattern[1].length());

			if(first.equals(mypattern[0]) && second.equals(mypattern[1]))
				sb.append("DA\n");
			else
				sb.append("NE\n");
		}

		System.out.println(sb);
	}	
 
}