class Solution {
    public String solution(String s) {
        String answer = "";
        
        String my[] = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(String cur : my)
        {
            int cur2 = Integer.parseInt(cur);
            if(max <=cur2)
                max= cur2;
            
            if(min >= cur2)
                min = cur2;
        }
        
        answer = min +" " +max;
        return answer;
    }
}