import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<T; i++) {
            String input = br.readLine();

            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();

            for(int j =0; j<input.length(); j++) {
                if(input.charAt(j) =='>') {
                    if(!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                }
                else if(input.charAt(j) == '<') {
                    if(!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                }
                else if(input.charAt(j) =='-') {
                    if(!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                }
                else {
                    leftStack.push(input.charAt(j));
                }
            }

            while(!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }

            while(!rightStack.isEmpty()) {
                sb.append(rightStack.pop());
            }
            if(i != T-1)
                sb.append("\n");
        }

        System.out.println(sb);
    }
}