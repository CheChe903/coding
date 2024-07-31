class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int notidx =1;
        for(int i =0; i<stations.length; i++)
        {
            int startCoverage = stations[i] - w;
            
            if (notidx < startCoverage) 
            {
                int uncoveredLength = startCoverage - notidx;
                if (uncoveredLength % (2 * w + 1) == 0) 
                {
                    answer += uncoveredLength / (2 * w + 1);
                } 
                else 
                {
                    answer += uncoveredLength / (2 * w + 1) + 1;
                }
            }
            
            notidx = stations[i] + w + 1;
        }
        
        if (notidx <= n) 
        {
            int uncoveredLength = n - notidx + 1;
            if (uncoveredLength % (2 * w + 1) == 0) 
            {
                answer += uncoveredLength / (2 * w + 1);
            } else 
            {
                answer += uncoveredLength / (2 * w + 1) + 1;
            }
        }
        
        return answer;
    }
}