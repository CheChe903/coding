import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int curOrder =0;
        int curBox= 1;
        while(curOrder < order.length && curBox <= order.length)
        {
                if(!stack.isEmpty() && stack.peek() > order[curOrder] && curBox > order[curOrder])
                    break;
                else if(stack.isEmpty() && order[curOrder] < curBox)
                    break;
                else if( curOrder== order.length-1 && curBox == order.length && stack.isEmpty())
                    break;
                
                else if(order[curOrder] == curBox)
                {
                    curOrder++;
                    curBox++;
                    answer++;
                }
                
                else if(!stack.isEmpty() && stack.peek() == order[curOrder])
                {
                    stack.pop();
                    curOrder ++;
                    answer++;
                }
                else if(order[curOrder] > curBox)
                {
                    stack.push(curBox);
                    curBox++;
                }

            
           
        }
        while(!stack.isEmpty() && stack.peek() == order[curOrder])
        {
            stack.pop();
            curOrder ++;
            answer++;
        }
        
        return answer;
    }
   
}
