class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i =0; i<s.length(); i++) {
            if(s.charAt(i) >=48 && s.charAt(i) <=57) {
                answer *= 10;
                answer += Integer.parseInt(s.charAt(i) +"");
            }
            else {
                String currentNumString = "";
                while(true) {
                    currentNumString += (s.charAt(i) +"");
                    i+=1;
                    if(checkNum(currentNumString) != -1) {
                        int cur = checkNum(currentNumString);
                        answer *=10;
                        answer += cur;
                        break;
                    } 
                }
                i--; 
            }
        }
        return answer;
    }
    
    static int checkNum(String cur) {
        if(cur.equals("zero")) {
            return 0;
        }
        else if(cur.equals("one")) {
            return 1;
        }
        else if(cur.equals("two")) {
            return 2;
        }
        else if(cur.equals("three")) {
            return 3;
        }
        else if(cur.equals("four")) {
            return 4;
        }
        else if(cur.equals("five")) {
            return 5;
        }
        else if(cur.equals("six")) {
            return 6;
        }
        else if(cur.equals("seven")) {
            return 7;
        }
        else if(cur.equals("eight")) {
            return 8;
        }
        else if(cur.equals("nine")) {
            return 9;
        }
        return -1;
    }
    
}