import java.util.*;

class Solution {
    static String answer;
    public String solution(String p) {
        answer = "";
        if(check(p))
            return p;
        
        answer = func(p);
        return answer;
    }
    
    static String func(String str)
    {            
        if(str =="")
            return "";
        int count =0;
        int count2 =0;
        String u="";
        String v="";
        for(int i =0; i<str.length(); i++)
        {

            if(str.charAt(i) =='(')
                count++;
            else if(str.charAt(i)==')')
                count2++;
            
            if(count == count2)
            {
                u =str.substring(0,i+1);
                v= str.substring(i+1);
                break;
            }
        }
        if(check(u))
        {
            return u+func(v);
        }
        else
        {
            String str2 ="(";
            
            str2+=func(v);
            str2 +=")";
            
            String u2 = u.substring(1,u.length()-1);
            
            String plus ="";
            for(int i =0; i<u2.length(); i++)
            {
                if(u2.charAt(i)=='(')
                    plus+=')';
                else
                    plus+='(';
            }
            str2+=plus;
            return str2;
            
        }

    }
    
    static boolean check(String str)
    {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i =0; i<str.length(); i++)
        {
            if(str.charAt(i)=='(')
            {
                stack.push('(');
            }
            else if(str.charAt(i)==')')
            {
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
                else if(stack.isEmpty())
                {
                    return false;
                }
            }
        }
        if(stack.size()==0)
            return true;
        else
            return false;
    }
}