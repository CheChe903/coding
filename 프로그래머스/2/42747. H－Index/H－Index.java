class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int arr[] = new int[citations.length+1];
        
        for(int i : citations)
        {
            int cur =i;
            if(cur > citations.length)
                cur = citations.length;
            
            arr[cur]++;
        }
        int sum =0;
        for(int i = arr.length-1; i>=1; i--)
        {
            sum += arr[i];
            
            if(sum >= i)
            {
                answer = i;
                break;
            }
        }
        return answer;
    }
}