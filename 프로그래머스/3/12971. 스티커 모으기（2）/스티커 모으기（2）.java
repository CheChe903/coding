class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        
        int dp[] = new int[sticker.length];
        
        if (dp.length == 1) return sticker[0];

        dp[0] = sticker[0];
        dp[1] = sticker[0];
        
        
        for(int i =2; i<dp.length-1; i++) {
            
            dp[i] = Math.max(dp[i-2]+ sticker[i] , dp[i-1]);
        }
        
        answer = dp[sticker.length-2];
        
        
        dp = new int[sticker.length];
        
        dp[0] = 0;
        dp[1] = sticker[1];
        for(int i =2; i<dp.length; i++) {
            
            dp[i] = Math.max(dp[i-2]+ sticker[i] , dp[i-1]);
        }
        answer = Math.max(dp[sticker.length-1], answer);

        return answer;
    }
}