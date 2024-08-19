import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String input = br.readLine();
            if (input.equals(".")) break;
            
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;
            
            for (char c : input.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == ']') {
                    if (stack.isEmpty()) {
                        isBalanced = false;
                        break;
                    }
                    char top = stack.pop();
                    if ((c == ')' && top != '(') || (c == ']' && top != '[')) {
                        isBalanced = false;
                        break;
                    }
                }
            }
            
            if (!stack.isEmpty()) isBalanced = false;
            sb.append(isBalanced ? "yes\n" : "no\n");
        }
        
        System.out.print(sb);
    }
}