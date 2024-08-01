import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        HashMap<Integer, String> map = new HashMap<>();
        
        int cacheIndex =1;
        int popIndex =1;
        
        if(cacheSize ==0 )
            return cities.length *5;
        for(int i =0; i<cities.length; i++)
        {
            String curCity = cities[i].toLowerCase();
            
            if(!map.containsValue(curCity))
            {
                if(map.size() < cacheSize)
                {
                    map.put(cacheIndex,curCity);
                    cacheIndex++;
                }
                else if(map.size() == cacheSize)
                {
                    while(!map.containsKey(popIndex))
                        popIndex++;
                    map.remove(popIndex);
                    map.put(cacheIndex,curCity);
                    cacheIndex++;
                    popIndex++;
                }
                answer +=5;
            }
            else
            {
                int findKey =-1;
                for(Integer key : map.keySet()) {
                    if(map.get(key).equals(curCity)) { 
                        findKey = key;
                        break;
                    }
                }
                map.remove(findKey);
                map.put(cacheIndex,curCity);
                answer +=1;
                cacheIndex++;
                
            }
        }
        
        return answer;
    }
}