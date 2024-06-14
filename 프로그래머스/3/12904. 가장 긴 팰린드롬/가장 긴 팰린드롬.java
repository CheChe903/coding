import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer =0;
        
        int start =0;
        int end =s.length();
        for(int i=0; i< s.length()/2+1; i++)
        {
            start = 0+i;
            end = s.length() -i-1;
            while(true)
            {

                if(answer > end-start)
                    break;

                if(pal(s,start,end))
                {
                    answer = end-start;
                    break;
                }
                start++;
            }
            start = 0+i;
            end = s.length() -i-1;
            while(true)
            {

                if(answer > end-start)
                    break;

                if(pal(s,start,end))
                {
                    answer = end-start;
                    break;
                }
                end--;
            }
        }
        return answer+1;
    }
    
    public boolean pal(String s, int left, int right)
    {
        
        while(left <right)
        {
            if(s.charAt(left) != s.charAt(right))
                return false;
            
            left++;
            right--;
        }
        
        return true;
    }
}