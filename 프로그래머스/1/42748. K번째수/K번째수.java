import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        answer = new int[commands.length];
        for(int i =0; i<commands.length; i++)
        {
            int start = commands[i][0];
            int end = commands[i][1];
            int findindex = commands[i][2];
            
            int [] myanswer = new int[end-start+1];
            
            for(int j =0; j<myanswer.length; j++)
            {
                myanswer[j]=array[start-1];
                start++;
            }
            Arrays.sort(myanswer);
            
            answer[i] = myanswer[findindex-1];
        }
        return answer;
    }
}