import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i =1; i<=26; i++)
        {
            map.put(Character.toString(i+ 'A'-1),i);
        }
        /*
        for(int i =1; i<=26; i++)
        {
            System.out.print(map.get(Character.toString(i+ 'A'-1)));
        }
        */

        int index =0;
        int curIndex=27;
        while(index <msg.length())
        {
            String cur = Character.toString(msg.charAt(index));
            int nextIndex = index+1;
            
            while(nextIndex <= msg.length() && map.containsKey(cur)) 
            {
                if (nextIndex == msg.length()) break;
                cur += msg.charAt(nextIndex);
                nextIndex++;
            }

            if (!map.containsKey(cur)) 
            {
                cur = cur.substring(0, cur.length() - 1);
                nextIndex--;
            }

            answer.add(map.get(cur));

            if (nextIndex < msg.length()) 
            {
                String newEntry = cur + msg.charAt(nextIndex);
                map.put(newEntry, curIndex);
                curIndex++;
            }

            index = nextIndex;
            
        }
        
        int[] array = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) 
        {
            array[i] = answer.get(i);
        }
        return array;
    }
}