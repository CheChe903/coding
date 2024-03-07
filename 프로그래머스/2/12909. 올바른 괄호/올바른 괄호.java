import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;  
        
        Stack<Character> stack =new Stack<>();
        
        
        String str = s;

        boolean check = false;
        for(int i =0; i<str.length(); i++)
        {
            if(str.charAt(i) == '(')
            {
                stack.push(str.charAt(i));
                check= true;
            }
            else if(!stack.isEmpty() && str.charAt(i) == ')')
            {
                stack.pop();
            }
            else if(stack.isEmpty() && str.charAt(i) == ')')
            {
                return false;
            }
              
        }
        
        if(check)
        {
            if(stack.isEmpty())
                answer = true;
            else
                answer= false;
        }
        else
            answer= false;


        return answer;
    }
}