import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        int cnt =0;
        int min = 15;
        for(int i =score.length-1; i>=0; i--)
        {
            if(min>score[i])
                min=score[i];
            cnt++;
            if(cnt==m)
            {
                answer+=min*cnt;
                cnt=0;
            }
        }
        return answer;
    }
}