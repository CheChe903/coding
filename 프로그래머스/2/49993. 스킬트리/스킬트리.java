import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i =0; i<skill_trees.length; i++)
        {
            int cur=0;
            boolean check= true;
            for(int j=0; j<skill_trees[i].length(); j++)
            {
         
                if(skill.contains(skill_trees[i].substring(j,j+1)))
                {
                    if(cur != skill.indexOf(skill_trees[i].charAt(j)))
                    {
                        check=false;
                        break;
                    }
                    else if(cur == skill.indexOf(skill_trees[i].charAt(j)))
                    {
                        cur++;
                    }
                }

            }
            if(check)
                answer++;
        }
        
        
        return answer;
    }
}