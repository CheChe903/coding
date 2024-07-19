import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
       
        Arrays.sort(section);
        int check =0;
        for(int i = 0; i< section.length; i++)
        {

            if(i == 0)
            {
                answer++;   
                check=section[i];
            }
            else
            {
                if(section[i] -check<m)
                    continue;
                else
                {
                    check=section[i];
                    answer++;
                }
            }
        }
        
        return answer;
    }
}