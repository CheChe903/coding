class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int n = sequence.length-1;
        int start=n;
        int end=n;
        int sum =sequence[start];
        while(true)
        {
            if(sum==k || (end ==0 && start==0))
                break;
            
            if(sum<k)
            {
                if(end>0)
                    end-=1;
                else
                    start-=1;
                sum+=sequence[end];
            }
            else if(sum>k)
            {
                sum-=sequence[start];
                if(start>=end)
                    start-=1;
                else
                    end-=1;
            }
        }
        int index=0;
        for(int i =0; i<=end; i++)
        {
            if(sequence[i]==sequence[start])
            {
                index=i;
                int temp =start-end;
                end=index;
                start = index+temp;
                break;
            }
        }
        
        answer= new int[2];
        answer[0]=end;
        answer[1]=start;
        return answer;
    }
}