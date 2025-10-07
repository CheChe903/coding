class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        int maxLength = s.length()/2;
        
        for(int i =1; i <=maxLength; i++) {
        
            String currentAnswer = "";    
            int count  = 1;
            String currentString = s.substring(0, i);
            for(int j = i; j < s.length(); j+=i) {
                String currentString2 = s.substring(j, Math.min(j + i, s.length()));
                if(currentString.equals(currentString2)) {
                    count+=1;
                }
                else {
                    if(count !=1) {
                        currentAnswer += count;
                    }        
                    currentAnswer += currentString;
                    currentString = currentString2;
                    count =1;
                }
            }
            
            if (count != 1) currentAnswer += count;
            currentAnswer += currentString;
            if(currentAnswer.length() < answer) {
                answer = currentAnswer.length();
            }
        }
        
        return answer;
    }
}

// 1. 1개 자르는 것부터 n/2까지 진행
// 2. 