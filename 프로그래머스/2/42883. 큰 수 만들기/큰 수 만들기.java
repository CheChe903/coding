import java.util.*;

class Solution {
    //9 4
    public String solution(String number, int k) {
        String answer = "";
        
        Stack<Integer> stack = new Stack<>();
        
        int size = number.length() -k;
        
        for(int i =0; i<number.length(); i++)
        {
            int cur = Integer.parseInt(number.substring(i,i+1));

            if(stack.size()==0)
            {
                stack.push(cur);
                k--;
            }
            
            else if(cur > stack.peek())
            {
                while(!stack.isEmpty() && k>=0 &&cur > stack.peek())
                {
                    stack.pop();
                    k--;
                }
                stack.push(cur);
            }
            else
                stack.push(cur);
        }
        
        while(stack.size() > size)
        {
            stack.pop();
        }
        while(!stack.isEmpty())
        {
            answer = stack.pop()+ answer; 
            size--;
        }
        
        return answer;
    }
}

