class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int dp[][] = new int[501][501];
        
        dp[0][0] = triangle[0][0];
        
        for(int i=0; i<triangle.length-1; i++) {
            for(int j =0; j<triangle[i].length; j++) {
                if(i+1 < triangle.length) {
                    dp[i+1][j] = Math.max(dp[i+1][j],dp[i][j] + triangle[i+1][j]);
                }
                if(i+1 < triangle.length && j+1 <triangle.length) {
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1],dp[i][j] + triangle[i+1][j+1]);
                }
            }
        }
        for(int i= 0; i<triangle.length; i++) {
            answer = Math.max(answer, dp[triangle.length-1][i]);
        }
        
        return answer;
    }
}