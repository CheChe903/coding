import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        ArrayList<Integer> time = new ArrayList<>();
        ArrayList<String> number = new ArrayList<>();
        HashMap<String,Integer> hash = new HashMap<String,Integer>();
        
        for(int i=0; i<records.length; i++)
        {
            if(number.contains(records[i].substring(6,10)))
            {
                int index = number.indexOf(records[i].substring(6,10));
                if(!time.isEmpty() && index < time.size())
                {
                    int mtime = time.remove(index);
                    int mtime2 = Integer.parseInt(records[i].substring(0,2))*60;
                    mtime2 += Integer.parseInt(records[i].substring(3,5));
                    mtime2 = mtime2 - mtime;
                    number.remove(records[i].substring(6,10));
                    hash.put(records[i].substring(6,10), hash.getOrDefault(records[i].substring(6,10), 0) + mtime2);
                    
                    
                }
            }
            else
            {
                number.add(records[i].substring(6,10));
                int mytime = Integer.parseInt(records[i].substring(0,2))*60;
                mytime += Integer.parseInt(records[i].substring(3,5));
                time.add(mytime);
            }
        }

        for(String num : number)
        {
            int index = number.indexOf(num);
            hash.put(num, hash.getOrDefault(num, 0) + (1439-time.get(index)));
        }
        
        List<String> keyList = new ArrayList<>(hash.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        answer= new int[hash.size()];
        int k =0;
        for (String key : keyList) {
            
            int feetime = hash.get(key);
            
             
            float realfee= 0;
            float asd = fees[2];
            answer[k]+=fees[1];
            if(feetime>fees[0])
            {
                realfee = feetime-fees[0];
                feetime = (int)Math.ceil(realfee/asd);
                answer[k] += feetime * fees[3];
            }
            

            k++;
        }
        return answer;
    }
}
