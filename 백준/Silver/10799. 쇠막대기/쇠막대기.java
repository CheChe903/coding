import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.*;
public class Main {

 
	public static void main(String[] args) throws IOException {

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> stack = new Stack<>();
		String str = br.readLine();
		int answer =0;

		for(int i =0; i<str.length(); i++)
		{
			if(str.charAt(i)=='(')
				stack.push(str.charAt(i));
			else
			{
				stack.pop();

				if(str.charAt(i-1)=='(')
					answer +=stack.size();
				else
					answer++;
			}
		}
		

		System.out.println(answer);

	}


}