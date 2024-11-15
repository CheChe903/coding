import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String input = br.readLine();

		StringTokenizer st;

		int M = Integer.parseInt(br.readLine());
	
		Stack<String> leftStack = new Stack<>();
		Stack<String> rightStack = new Stack<>();
		String[] arr = input.split("");
		for(int i =0; i<input.length(); i++) {
			leftStack.push(arr[i]);
		}


		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(command.equals("P")) {
				leftStack.push(st.nextToken());
			}
			else if(!leftStack.isEmpty() && command.equals("B")) {
				leftStack.pop();
			}
			else if(!leftStack.isEmpty() && command.equals("L")) {
				rightStack.push(leftStack.pop());
			}
			else if(!rightStack.isEmpty() && command.equals("D")) {
				leftStack.push(rightStack.pop());
			}
		}
		
		while(!leftStack.isEmpty()) {
			rightStack.push(leftStack.pop());
		}
		StringBuilder sb=  new StringBuilder();
		while(!rightStack.isEmpty()) {
			sb.append(rightStack.pop());
		}	
		System.out.println(sb);
	}


}
