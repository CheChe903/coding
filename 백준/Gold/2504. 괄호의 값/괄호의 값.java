import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        
        int answer = 0;
        boolean isValid = true;
        
        for(int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            
            if(currentChar == '(' || currentChar == '[') {
                stack.push(currentChar);
                valueStack.push(-1);
            } 
            else if(currentChar == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    isValid = false;
                    break;
                }
                
                stack.pop();
                int value = 0;
                
                while(!valueStack.isEmpty() && valueStack.peek() != -1) {
                    value += valueStack.pop();
                }
                
                valueStack.pop();
                
                value = value == 0 ? 2 : value * 2;
                valueStack.push(value);
            } 
            else if(currentChar == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    isValid = false;
                    break;
                }
                
                stack.pop();
                int value = 0;
                
            
                while(!valueStack.isEmpty() && valueStack.peek() != -1) {
                    value += valueStack.pop();
                }
                
                valueStack.pop();
                
            
                value = value == 0 ? 3 : value * 3;
                valueStack.push(value);
            }
            else {
            
                isValid = false;
                break;
            }
        }
        
    
        if(!stack.isEmpty()) {
            isValid = false;
        }
        
        if(isValid) {
            while(!valueStack.isEmpty()) {
                answer += valueStack.pop();
            }
            System.out.println(answer);
        } else {
            System.out.println(0);
        }
    }
}