class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long answer = limit;
        
        for(int diff: diffs) answer = Math.max(diff, answer);
        
        long start =1;
        long end = answer;
        
        
        
        while(start<=end) {
            long mid = start + (end - start)/2;
            long current = sol(mid, diffs, times);
            
            if(current <= limit) {
                answer = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return (int) answer;
    }
    
    public long sol(long limit, int[] diffs, int[] times) {
        long currentAnswer = 0;
        for(int i =0; i<diffs.length; i++) {
            if(limit >= diffs[i]) {
                currentAnswer += times[i];
            }
            else {
                long wrong = diffs[i] - limit;
                currentAnswer += ((times[i] + times[i-1]) * wrong) + times[i];
            }
        }
        return currentAnswer;
    }
}