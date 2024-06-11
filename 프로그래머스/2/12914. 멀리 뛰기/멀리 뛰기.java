class Solution {
    public long solution(int n) {
        long answer;
        
        int dp[] = new int[n+5];
        
        dp[1]=1;
        dp[2] =2;
        
        for(int i =3; i<=n; i++)
        {
            dp[i] = (dp[i-1] + dp[i-2])%1234567; 
        }
        
        
        return dp[n];
    }

}