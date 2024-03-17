import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
 
        for (int i = 0; i < 10; i++) {
            hash.put(discount[i], hash.getOrDefault(discount[i], 0) + 1);
            
        }
        
        int index = 10;
        
        while (index <=discount.length) 
        {
            int count = 0;
            for (int i = 0; i <want.length; i++) {
                if (hash.containsKey(want[i]) &&number[i] == hash.get(want[i]))
                {   
                    count++;
                
                }
                  
                
            }
            if (count == want.length)
                answer++;
            
            hash.put(discount[index - 10], hash.getOrDefault(discount[index - 10], 0) - 1);
            if (index < discount.length) 
            {
                hash.put(discount[index], hash.getOrDefault(discount[index], 0) + 1);
            }
            index++;
        }

        return answer;
    }
}
