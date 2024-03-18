import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int cnt=0;
        if(d.length>=1&& d[0]<=budget)
        {
            cnt+=d[0];
            answer++;
        }
        for(int i =0; i<d.length; i++)
        {
            
            if(i+1<d.length && cnt+d[i+1]<=budget)
            {
                cnt+=d[i+1];
                answer++;
            }
            else
            {
                break;
            }
        }
        return answer;
    }
}