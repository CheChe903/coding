import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        answer = new int[2];
        HashMap<String,Integer> hash = new HashMap<String,Integer>();
        
        char cur =words[0].charAt(words[0].length()-1);
        hash.put(words[0],1);
        for(int i =1; i<words.length; i++)
        {
            
            if(cur != words[i].charAt(0))
            {
                answer[0]=i%n+1;
                answer[1]=i/n+1;
                break;
            }
            else if(hash.containsKey(words[i]))
            {
                answer[0]=i%n+1;
                answer[1]=i/n+1;
                break;
            }

            else if(!hash.containsKey(words[i]))
            {

                hash.put(words[i],1);
                cur = words[i].charAt(words[i].length()-1);
            }
        }

        return answer;
    }
}