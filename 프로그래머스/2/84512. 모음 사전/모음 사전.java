import java.util.*;

class Solution {
    
    char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    ArrayList<String> list;
    public int solution(String word) {
        int answer = 0;
        
        list = new ArrayList<>();
        dfs("");
        for(int i =0; i<list.size(); i++)
        {
            if(word.equals(list.get(i)))
            {
                answer =i;
                break;
            }
            
        }
        
        return answer;
    }
    
    public void dfs(String result)
    {
        list.add(result);
        
        if(result.length() == 5)
            return;
        
        for(int i =0; i<alpha.length; i++)
        {
            dfs(result + alpha[i]);
        }
    }
}