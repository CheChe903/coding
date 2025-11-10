import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int i =0; i<citations.length; i++) {
            int cur = citations[i];
            
            if(citations.length- i <= cur) {
                answer= citations.length-i;
                break;
            }
        }        
        return answer;
    }
}

//0 1 3 5 6
//1 2 5 6 7