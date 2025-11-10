class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i = 1; i<= s.length()/2; i++) { //i는 자를 갯수
            // 맨 앞에부터 시작해서 크기만큼 잘라서 그걸로 이어가기 해야함.
            
            String sub = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int j=i; j<s.length(); j+=i) {
                int endIdx = Math.min(j + i, s.length());
                String currentSub = s.substring(j, endIdx);
                
                if(sub.equals(currentSub)) {
                    count++;
                } else {
                    if(count > 1) {
                        sb.append(count);
                    }
                    sb.append(sub);
                    count = 1;
                    sub = currentSub;
                }                               
            }
            if(count >1) sb.append(count);
            sb.append(sub);
            answer = Math.min(sb.length(), answer);
        }
        
        return answer;
    }
}