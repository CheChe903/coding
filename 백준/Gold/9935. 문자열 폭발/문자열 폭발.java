import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String bomb = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        for(int i =0; i<input.length(); i++){
            stack.push(input.charAt(i));

            if(stack.size() >= bomb.length()) {
                boolean check =true;

                for(int j =0; j<bomb.length(); j++) {
                    if(stack.get(stack.size() - bomb.length() +j) != bomb.charAt(j)) {
                        check= false;
                        break;
                    }
                }
    
                if(check) {
                    for(int j =0; j<bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }

        }

        if(stack.isEmpty()) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            for(Character c : stack) sb.append(c);
            System.out.println(sb);
        }
    }
}
