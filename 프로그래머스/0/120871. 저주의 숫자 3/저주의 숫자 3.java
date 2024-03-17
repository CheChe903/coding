class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i =0; i<n; i++)
        {
            answer++;
            String str = answer+"";
            while(answer%3 ==0 || str.contains("3"))
            {
                answer++;
                str = answer+"";

            }
        }
        return answer;
        //11 17 
        //12 19
    }
}