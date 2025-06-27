import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(String str1, String str2) {
            
        String lowerStr1 = str1.toLowerCase();
        String lowerStr2 = str2.toLowerCase();
    
        Map<String, Integer> str1List = new HashMap<>();
        for(int i =0; i<lowerStr1.length()-1; i++) {
            String substringStr = lowerStr1.substring(i, i+2);
            if(substringStr.charAt(0) < 97 || substringStr.charAt(0) >122 
              || substringStr.charAt(1) < 97 || substringStr.charAt(1) > 122) {
                continue;
            }
            str1List.put(substringStr, str1List.getOrDefault(substringStr,0) +1);
        }
        
        Map<String, Integer> str2List = new HashMap<>();
        for(int i =0; i<lowerStr2.length()-1; i++) {
            String substringStr = lowerStr2.substring(i, i+2);
            if(substringStr.charAt(0) < 97 || substringStr.charAt(0) >122 
              || substringStr.charAt(1) < 97 || substringStr.charAt(1) > 122) {
                continue;
            }
            str2List.put(substringStr, str2List.getOrDefault(substringStr,0) +1);
        }
        
        if(str1List.size() == 0 && str2List.size() ==0) {
            return 65536;
        }
        
        int union = 0;
        int intersection = 0;
        Set<String> visited = new HashSet<>();
        for (String key : str1List.keySet()) {
            int str1Count = str1List.get(key);
            int str2Count = 0;
            if(str2List.containsKey(key)) {
                str2Count = str2List.get(key);
            }
            
            int max = Math.max(str1Count, str2Count);
            int min = Math.min(str1Count, str2Count);
            union += max;
            intersection += min;
            visited.add(key);
        }
        
        for(String key : str2List.keySet()) {
            if(!visited.contains(key)) {
                union += str2List.get(key);
            }
        }
        
        double sum = (double)intersection/(double)union;
        
        int answer = (int)(sum * 65536.0);
        
        return answer;
    }
    //97 122
    
}