class Solution {
    //6 66 666 6666 66666
    //6 은 10 1번 -1 4번 
    //16은 10 2번 -1 4번 6번
    //1 2 3 4 5 6 7 8 9 10
    //1 2 3 4 5 5 4 3 2 1
    //66 - > 100 1번 왜 ? -10 3번 -1 4번 
    public int solution(int storey) {
        int answer = 0;
        int cur = storey;
        //16 4 + 2 
        // 2554  -> 2560 (4) -> 2600 (8)  
        while(cur != 0)
        {
            if(cur %10 >5)
            {
                answer += (10 - cur%10);
                
                cur = cur/10;
                cur++;
            }
            else if(cur%10 ==5)
            {
                int cur2 = cur/10;
                if(cur2%10 >=5)
                {
                    answer += (10 - cur%10);

                    cur = cur/10;
                    cur++;
                }
                else
                {
                    answer += cur%10;
                    cur = cur/10;
                }
            }
            else
            {
                answer += cur%10;
                cur = cur/10;
            }
        }
        
        return answer;
        
        //
    }
}