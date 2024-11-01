import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        System.out.println(rotateLeft(s));
        
        for(int i =0; i< s.length(); i++) {
            if(isGoodString(s))
                answer++;
            
            s= rotateLeft(s);
        }
        
        return answer;
    }
    
    
    
    static String rotateLeft(String s) {
        
        char temp = s.charAt(0);
        
        s = s.substring(1);
        s += temp+"";
        
        return s;
    }
    static boolean isGoodString(String s) {
        Stack<Character> stack  = new Stack<>();
        
        for(int i =0; i<s.length(); i++) {
            if(s.charAt(i) == '[' || s.charAt(i) =='(' || s.charAt(i)=='{') {
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) ==']') {
                if(!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                }
                else
                    return false;
            }
            else if(s.charAt(i) =='}') {
                if(!stack.isEmpty() &&stack.peek() == '{') {
                    stack.pop();
                }
                else
                    return false;
            }
            else if(s.charAt(i) ==')') {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                else
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;

        return false;
           
        
    }
}