import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int index =1;
        StringBuilder sb = new StringBuilder();
        while(true) {
            String input = br.readLine();
            if(input.contains("-")) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            int answer = 0;
            for(int i =0; i<input.length(); i++) {
                if(input.charAt(i) == '{') {
                    stack.add('{');
                } 
                else {
                    if(stack.isEmpty()) {
                        answer+=1;
                        stack.add('{');
                    }
                    else {
                        stack.pop();
                    }
                }
            }
            System.out.println(index +". " + (answer + stack.size()/2));
            index+=1;
        }
    }
}